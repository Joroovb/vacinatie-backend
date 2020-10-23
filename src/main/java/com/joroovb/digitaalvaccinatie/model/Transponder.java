package com.joroovb.digitaalvaccinatie.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Transponder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Date implementationDate;
    private String transponderLocation;
    private int transponderCode;

    @OneToOne
    private Animal animal;

    // Getters & Setters

    public long getId() {
        return id;
    }

    public Date getImplementationDate() {
        return implementationDate;
    }

    public void setImplementationDate(Date implementationDate) {
        this.implementationDate = implementationDate;
    }

    public String getTransponderLocation() {
        return transponderLocation;
    }

    public void setTransponderLocation(String transponderLocation) {
        this.transponderLocation = transponderLocation;
    }

    public int getTransponderCode() {
        return transponderCode;
    }

    public void setTransponderCode(int transponderCode) {
        this.transponderCode = transponderCode;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
