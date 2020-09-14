package com.joroovb.digitaalvaccinatie.contoller;

import com.joroovb.digitaalvaccinatie.model.Veterinarian;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class VeterinarianService {

    @Autowired
    VeterinarianRepository veterinarianRepository;

    public Veterinarian getById(long id) {
        return veterinarianRepository.getOne(id);
    }

    public Veterinarian newVet(Veterinarian veterinarian) {
        return veterinarianRepository.save(veterinarian);
    }

    public void deleteVet(long id) {
        veterinarianRepository.deleteById(id);
    }
}
