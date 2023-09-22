package com.siteproject.eticaret.repositories;

import com.siteproject.eticaret.entities.Street;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StreetRepository extends JpaRepository<Street, Integer> {

    Boolean existsByStreetName(String streetName);
}
