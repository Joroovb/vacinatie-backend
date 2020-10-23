package com.joroovb.digitaalvaccinatie.resolver;

import com.joroovb.digitaalvaccinatie.contoller.CaregiverRepository;
import com.joroovb.digitaalvaccinatie.contoller.LayoutRepository;
import com.joroovb.digitaalvaccinatie.model.Caregiver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class MutationResolver {

    @Autowired
    CaregiverRepository caregiverRepository;

    @Autowired
    LayoutRepository layoutRepository;

    @Transactional
    public Caregiver newCaregiver (Caregiver caregiver) {
        return caregiverRepository.save(caregiver);
    }
}
