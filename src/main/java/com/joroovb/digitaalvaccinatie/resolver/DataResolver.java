package com.joroovb.digitaalvaccinatie.resolver;

import com.joroovb.digitaalvaccinatie.contoller.CaregiverRepository;
import com.joroovb.digitaalvaccinatie.model.Caregiver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Component
public class DataResolver {

    @Autowired
    CaregiverRepository caregiverRepository;

    @Transactional
    public Caregiver getCaregiverData(long id) {
        try {
            return caregiverRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            return null;
        }
    }
}
