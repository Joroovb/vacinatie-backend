package com.joroovb.digitaalvaccinatie.contoller;

import com.joroovb.digitaalvaccinatie.model.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AnimalService {

    @Autowired
    AnimalRepository animalRepository;

    public Animal getById(long id) {
        return animalRepository.getOne(id);
    }

    public Animal newAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    public void deleteAnimal(long id) {
        animalRepository.deleteById(id);
    }
}
