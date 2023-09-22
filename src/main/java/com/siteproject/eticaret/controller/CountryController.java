package com.siteproject.eticaret.controller;

import com.siteproject.eticaret.core.utilities.result.Result;
import com.siteproject.eticaret.dtos.request.country.CreateCountryDto;
import com.siteproject.eticaret.services.country.CountryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @PostMapping("/addcountry")
    public Result addCountry(@Valid @RequestBody CreateCountryDto createCountryDto) {
        return this.countryService.addCountry(createCountryDto);
    }
}
