package com.joroovb.digitaalvaccinatie.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Veterinarian {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String practiceName;
    private String email;
    private long phoneNumber;
    private String address;
    private String zipcode;
    private String city;

    @OneToMany
    private List<Animal> animals;

    @OneToMany
    private List<Treatment> treatments;

    // Getters & Setters

    public long getId() {
        return id;
    }

    public String getPracticeName() {
        return practiceName;
    }

    public void setPracticeName(String practiceName) {
        this.practiceName = practiceName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public List<Treatment> getTreatments() {
        return treatments;
    }

    public void setTreatments(List<Treatment> treatments) {
        this.treatments = treatments;
    }
}
