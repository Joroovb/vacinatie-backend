package com.joroovb.digitaalvaccinatie.model;

import org.springframework.util.LinkedMultiValueMap;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private byte[] img;
    private String name;
    @Enumerated(EnumType.STRING)
    private Species species;
    private String race;
    private String colour;
    private String notableFeatures;
    private Date birthDate;
    @Enumerated(EnumType.STRING)
    private Gender gender;

    private LinkedMultiValueMap<Date, Double> weight;

    @OneToOne
    private Transponder transponder;

    @ManyToMany
    private List<Caregiver> caregivers = new ArrayList<Caregiver>();

    @ManyToOne
    private Veterinarian veterinarian;

    @OneToMany
    private List<Treatment> treatments;

    public Animal() {

    };

    public Animal(String name, Species species, String race, String colour, String notableFeatures, Gender gender) {
        this.name = name;
        this.species = species;
        this.race = race;
        this.colour = colour;
        this.notableFeatures = notableFeatures;
        this.gender = gender;
    }

    // Getters & Setters

    public long getId() {
        return id;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getNotableFeatures() {
        return notableFeatures;
    }

    public void setNotableFeatures(String notableFeatures) {
        this.notableFeatures = notableFeatures;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setSex(Gender gender) {
        this.gender = gender;
    }

    public LinkedMultiValueMap<Date, Double> getWeight() {
        return weight;
    }

    public void setWeight(LinkedMultiValueMap<Date, Double> weight) {
        this.weight = weight;
    }

    public Transponder getTransponder() {
        return transponder;
    }

    public void setTransponder(Transponder transponder) {
        this.transponder = transponder;
    }

    public List<Caregiver> getCaregivers() {
        return caregivers;
    }

    public void setCaregivers(Caregiver caregiver) {
        this.caregivers.add(caregiver);
    }

    public Veterinarian getVeterinarian() {
        return veterinarian;
    }

    public void setVeterinarian(Veterinarian veterinarian) {
        this.veterinarian = veterinarian;
    }

    public List<Treatment> getTreatments() {
        return treatments;
    }

    public void setTreatments(List<Treatment> treatments) {
        this.treatments = treatments;
    }
}
