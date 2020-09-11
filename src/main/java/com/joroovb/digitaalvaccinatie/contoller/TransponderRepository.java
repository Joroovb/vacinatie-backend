package com.joroovb.digitaalvaccinatie.contoller;

import com.joroovb.digitaalvaccinatie.model.Transponder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransponderRepository extends JpaRepository<Transponder, Long> {
}
