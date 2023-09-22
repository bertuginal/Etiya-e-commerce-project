package com.siteproject.eticaret.repositories;

import com.siteproject.eticaret.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {

    boolean existsByCountryName(String countryName);
}
