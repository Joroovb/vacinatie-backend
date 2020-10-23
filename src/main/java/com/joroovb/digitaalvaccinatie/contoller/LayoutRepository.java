package com.joroovb.digitaalvaccinatie.contoller;

import com.joroovb.digitaalvaccinatie.model.Layout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LayoutRepository extends JpaRepository<Layout, Long> {

    @Query("SELECT l FROM Layout l WHERE l.i = ?1")
    Layout findLayoutByI(char i);
}
