package com.joroovb.digitaalvaccinatie.contoller;

import com.joroovb.digitaalvaccinatie.model.*;
import graphql.schema.DataFetcher;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.*;

@Component
public class GraphQLDataFetchers {

    @Autowired
    CaregiverRepository caregiverRepository;

    @Autowired
    LayoutRepository layoutRepository;

    @Autowired
    AnimalRepository animalRepository;

    public DataFetcher getCaregiverDataDataFetcher() {
        return dataFetchingEnvironment -> {
            long caregiverId = Long.parseLong(dataFetchingEnvironment.getArgument("id"));
            return caregiverRepository.findAll()
                    .stream()
                    .filter(caregiver -> caregiver.getId() == caregiverId)
                    .findFirst()
                    .orElse(null);
        };
    }

    public DataFetcher newCaregiverDataFetcher() {
        return dataFetchingEnvironment -> {
            String firstName = dataFetchingEnvironment.getArgument("firstName");
            String lastName = dataFetchingEnvironment.getArgument("lastName");
            String email = dataFetchingEnvironment.getArgument("email");
            int phoneNumber = dataFetchingEnvironment.getArgument("phoneNumber");
            String address = dataFetchingEnvironment.getArgument("address");
            String zipcode = dataFetchingEnvironment.getArgument("zipcode");
            String city = dataFetchingEnvironment.getArgument("city");
            List<Layout> layout = Arrays.asList(layoutRepository.save(new Layout('a', 0, 0, 2, 2, 2, 6)), layoutRepository.save(new Layout('b', 1, 0, 1, 2, 1, 4)), layoutRepository.save(new Layout('c', 4, 0, 1, 2, 1, 4)));
            Caregiver caregiver = new Caregiver(firstName, lastName, email, phoneNumber, address, zipcode, city, layout);
            layout.forEach(layout1 -> layout1.setCaregiver(caregiver));
            return caregiverRepository.save(caregiver);
        };
    }

    public DataFetcher updateLayoutDataFetcher() {
        return dataFetchingEnvironment -> {
            List<Layout> updateLayoutData = dataFetchingEnvironment.getArgument("data");
            for (Object layout : updateLayoutData.toArray()) {
                char ii = ((LinkedHashMap) layout).get("i").toString().charAt(0);
                Layout oldLayout = layoutRepository.findLayoutByI(ii);
                oldLayout.setX(Integer.parseInt(((LinkedHashMap) layout).get("x").toString()));
                oldLayout.setY(Integer.parseInt(((LinkedHashMap) layout).get("y").toString()));
                oldLayout.setW(Integer.parseInt(((LinkedHashMap) layout).get("w").toString()));
                oldLayout.setH(Integer.parseInt(((LinkedHashMap) layout).get("h").toString()));
                //oldLayout.setMinW(Integer.parseInt(((LinkedHashMap) layout).get("minW").toString()));
                //oldLayout.setMaxW(Integer.parseInt(((LinkedHashMap) layout).get("maxW").toString()));
            }
            Caregiver caregiver = caregiverRepository.findById((long) 4).get();
            caregiverRepository.save(caregiver);
            return caregiver.getLayout();
        };
    }

    public DataFetcher newAnimalDataFetcher() {
        return dataFetchingEnvironment -> {
            String name = dataFetchingEnvironment.getArgument("name");
            System.out.println(name);
            Species species = Species.valueOf(dataFetchingEnvironment.getArgument("species"));
            System.out.println(species);
            String race = dataFetchingEnvironment.getArgument("race");
            System.out.println(race);
            String colour = dataFetchingEnvironment.getArgument("colour");
            System.out.println(colour);
            String notableFeatures = dataFetchingEnvironment.getArgument("notableFeatures");
            Gender gender = Gender.valueOf(dataFetchingEnvironment.getArgument("gender"));
            System.out.println(gender);
            Caregiver caregiver = caregiverRepository.findById((long) 4).get();
            Animal animal = new Animal(name, species, race, colour, notableFeatures, gender);
            //animal.setCaregivers(caregiver);
            animalRepository.save(animal);
            caregiver.setAnimals(animal);
            caregiverRepository.save(caregiver);
            return animal;
        };
    }
}
