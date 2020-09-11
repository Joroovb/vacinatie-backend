package com.joroovb.digitaalvaccinatie.contoller;

import com.joroovb.digitaalvaccinatie.model.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreatmentRepository extends JpaRepository<Treatment, Long> {
}
