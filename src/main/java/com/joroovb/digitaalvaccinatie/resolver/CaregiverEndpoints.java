package com.joroovb.digitaalvaccinatie.rest;

import com.joroovb.digitaalvaccinatie.contoller.AnimalService;
import com.joroovb.digitaalvaccinatie.contoller.CaregiverService;
import com.joroovb.digitaalvaccinatie.model.Animal;
import com.joroovb.digitaalvaccinatie.model.Caregiver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/cg")
public class CaregiverEndpoints {

    @Autowired
    CaregiverService caregiverService;

    @Autowired
    AnimalService animalService;

    // Create and Manipulate Caregivers

    @GetMapping("/{id}")
    public Caregiver getById(@PathVariable(value = "id") long id) {
        return caregiverService.getById(id);
    }

    @PostMapping("/new")
    public Caregiver newCaregiver(@RequestBody Caregiver caregiver) {
        return caregiverService.newCaregiver(caregiver);
    }

    @DeleteMapping("/{id}")
    public void deleteCaregiver(@PathVariable(value = "id") long id) {
        caregiverService.deleteCaregiver(id);
    }

    // Create and Manipulate Animals

    @GetMapping("/an/{id}")
    public Animal getByAnimalId(@PathVariable(value = "id") long id) {
        return animalService.getById(id);
    }

    @PostMapping("/an/new")
    public Animal newAnimal(@RequestBody Animal animal) {
        return animalService.newAnimal(animal);
    }

    @DeleteMapping("/an/{id}")
    public void deleteAnimal(@PathVariable(value = "id") long id) {
        animalService.deleteAnimal(id);
    }

}
