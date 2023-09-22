package com.siteproject.eticaret.repositories;

import com.siteproject.eticaret.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Integer> {

    boolean existsByCityName(String cityName);
}
