package com.joroovb.digitaalvaccinatie.model;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import javax.persistence.*;
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
    private Sex sex;

    private LinkedMultiValueMap<Date, Double> weight;

    @OneToOne
    private Transponder transponder;

    @ManyToMany
    private List<Caregiver> caregivers;

    @ManyToOne
    private Veterinarian veterinarian;

    @OneToMany
    private List<Treatment> treatment;

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

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
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

    public void setCaregivers(List<Caregiver> caregivers) {
        this.caregivers = caregivers;
    }

    public Veterinarian getVeterinarian() {
        return veterinarian;
    }

    public void setVeterinarian(Veterinarian veterinarian) {
        this.veterinarian = veterinarian;
    }

    public List<Treatment> getTreatment() {
        return treatment;
    }

    public void setTreatment(List<Treatment> treatment) {
        this.treatment = treatment;
    }
}
