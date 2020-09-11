package com.joroovb.digitaalvaccinatie.contoller;

import com.joroovb.digitaalvaccinatie.model.Caregiver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaregiverRepository extends JpaRepository<Caregiver, Long> {
}
