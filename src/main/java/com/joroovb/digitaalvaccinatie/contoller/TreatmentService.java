package com.joroovb.digitaalvaccinatie.contoller;

import com.joroovb.digitaalvaccinatie.model.Treatment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TreatmentService {

    @Autowired
    TreatmentRepository treatmentRepository;

    public Treatment getTreatment(long id) {
        return treatmentRepository.getOne(id);
    }

    public Treatment newTreatment(Treatment treatment) {
        return treatmentRepository.save(treatment);
    }

    public void deleteTreatment(long id) {
        treatmentRepository.deleteById(id);
    }

    public List<Treatment> getAllTreaments() {
        return treatmentRepository.findAll();
    }
}
