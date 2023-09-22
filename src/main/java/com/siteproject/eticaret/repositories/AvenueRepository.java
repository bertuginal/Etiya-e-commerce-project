package com.siteproject.eticaret.repositories;

import com.siteproject.eticaret.entities.Avenue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvenueRepository extends JpaRepository<Avenue, Integer> {

    Boolean existsByAvenueName(String avenueName);
}
