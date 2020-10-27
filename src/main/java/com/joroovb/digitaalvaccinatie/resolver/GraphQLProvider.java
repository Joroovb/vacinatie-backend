package com.joroovb.digitaalvaccinatie.resolver;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import com.joroovb.digitaalvaccinatie.contoller.GraphQLDataFetchers;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URL;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

@Component
public class GraphQLProvider {

    @Autowired
    GraphQLDataFetchers graphQLDataFetchers;

    private GraphQL graphQL;

    @PostConstruct
    public void init() throws IOException {
        URL url = Resources.getResource("GraphQL/schema.graphqls");
        String sdl = Resources.toString(url, Charsets.UTF_8);
        GraphQLSchema graphQLSchema = buildSchema(sdl);
        this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();
    }

    private GraphQLSchema buildSchema(String sdl) {
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(sdl);
        RuntimeWiring runtimeWiring = buildWiring();
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        return schemaGenerator.makeExecutableSchema(typeRegistry, runtimeWiring);
    }

    private RuntimeWiring buildWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type(newTypeWiring("Query")
                        .dataFetcher("getCaregiverData", graphQLDataFetchers.getCaregiverDataDataFetcher()))
                .type(newTypeWiring("Mutation")
                        .dataFetcher("newCaregiver", graphQLDataFetchers.newCaregiverDataFetcher()))
                .type(newTypeWiring("Mutation")
                        .dataFetcher("updateLayout", graphQLDataFetchers.updateLayoutDataFetcher()))
                .type(newTypeWiring("Mutation")
                        .dataFetcher("newAnimal", graphQLDataFetchers.newAnimalDataFetcher()))
                .build();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/graphql").allowedOrigins("*");
            }
        };
    }

    @Bean
    public GraphQL graphQL() {
        return graphQL;
    }
}