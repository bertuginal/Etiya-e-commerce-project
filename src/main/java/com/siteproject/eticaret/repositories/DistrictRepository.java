package com.siteproject.eticaret.repositories;

import com.siteproject.eticaret.entities.District;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistrictRepository extends JpaRepository<District, Integer> {

    boolean existsByDistrictName(String districtName);
}
