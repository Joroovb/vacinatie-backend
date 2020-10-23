package com.joroovb.digitaalvaccinatie.resolver;

import com.joroovb.digitaalvaccinatie.contoller.AnimalService;
import com.joroovb.digitaalvaccinatie.contoller.TransponderService;
import com.joroovb.digitaalvaccinatie.contoller.TreatmentService;
import com.joroovb.digitaalvaccinatie.contoller.VeterinarianService;
import com.joroovb.digitaalvaccinatie.model.Animal;
import com.joroovb.digitaalvaccinatie.model.Transponder;
import com.joroovb.digitaalvaccinatie.model.Treatment;
import com.joroovb.digitaalvaccinatie.model.Veterinarian;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vet")
public class VeterinarianEndpoints {

    @Autowired
    VeterinarianService veterinarianService;

    @Autowired
    AnimalService animalService;

    @Autowired
    TransponderService transponderService;

    @Autowired
    TreatmentService treatmentService;

    // Create and Manipulate Veterinarians

    @GetMapping("/{id}")
    public Veterinarian getById(@PathVariable(value = "id") long id) {
        return veterinarianService.getById(id);
    }

    @PostMapping("/new")
    public Veterinarian newVet(@RequestBody Veterinarian veterinarian) {
        return veterinarianService.newVet(veterinarian);
    }

    @DeleteMapping("/{id}")
    public void deleteVet(@PathVariable(value = "id") long id) {
        veterinarianService.deleteVet(id);
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

    // Create and Manipulate Transponders

    @GetMapping("/tp/{id}")
    public Transponder getTransponder(@PathVariable(value = "id") long id) {
        return transponderService.getTransponder(id);
    }

    @PostMapping("/tp/new")
    public Transponder newTransponder(@RequestBody Transponder transponder) {
        return transponderService.newTransponder(transponder);
    }

    @DeleteMapping("/tp/{id}")
    public void deleteTransponder(@PathVariable(value = "id") long id) {
        transponderService.deleteTransponder(id);
    }

    // Create and Manipulate Transponder

    @GetMapping("/tm/{id}")
    public Treatment getTreatment(@PathVariable(value = "id") long id) {
        return treatmentService.getTreatment(id);
    }

    @PostMapping("/tm/new")
    public Treatment newTreatment(@RequestBody Treatment treatment) {
        return treatmentService.newTreatment(treatment);
    }

    @DeleteMapping("/tm/{id}")
    public void deleteTreatment(@PathVariable(value = "id") long id) {
        treatmentService.deleteTreatment(id);
    }

    @GetMapping("/tm/all")
    public List<Treatment> getAllTreaments() {
        return treatmentService.getAllTreaments();
    }
}
