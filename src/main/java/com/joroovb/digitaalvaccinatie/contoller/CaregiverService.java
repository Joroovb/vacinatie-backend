package com.joroovb.digitaalvaccinatie.contoller;

import com.joroovb.digitaalvaccinatie.model.Caregiver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CaregiverService {

    @Autowired
    CaregiverRepository caregiverRepository;

    public Caregiver getById(long id) {
        return caregiverRepository.getOne(id);
    }

    public Caregiver newCaregiver(Caregiver caregiver) {
        return caregiverRepository.save(caregiver);
    }

    public void deleteCaregiver(long id) {
        caregiverRepository.deleteById(id);
    }


}
