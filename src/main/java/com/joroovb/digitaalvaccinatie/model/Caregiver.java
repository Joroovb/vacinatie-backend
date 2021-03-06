package com.joroovb.digitaalvaccinatie.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Caregiver {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private long phoneNumber;
    private String address;
    private String zipcode;
    private String city;

    @ManyToMany
    private List<Animal> animals;

    @OneToMany(mappedBy="caregiver", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Layout> layout;

    // cascade={CascadeType.PERSIST, CascadeType.MERGE,
    //            CascadeType.REFRESH}
    public Caregiver() {

    }

    public Caregiver(String firstName, String lastName, String email, int phoneNumber, String address, String zipcode, String city, List<Layout> layout) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.zipcode = zipcode;
        this.city = city;
        this.layout = layout;
    }

    // Getters & Setters

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public void setAnimals(Animal animal) {
        this.animals.add(animal);
        animal.setCaregivers(this);
    }

    public List<Layout> getLayout() {
        return layout;
    }

    public void setLayout(Layout layout) {
        this.layout.add(layout);
        layout.setCaregiver(this);
    }

    public void removeLayout(Layout layout) {
        this.layout.remove(layout);
        //layout.setCaregiver(null);
    }
}
