package com.siteproject.eticaret.controller;

import com.siteproject.eticaret.core.utilities.result.Result;
import com.siteproject.eticaret.dtos.request.city.CreateCityDto;
import com.siteproject.eticaret.services.city.CityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/cities")
public class CityController {

    @Autowired
    private CityService cityService;

    @PostMapping("/addcity")
    public Result addCity(@Valid @RequestBody CreateCityDto createCityDto) {
        return this.cityService.addCity(createCityDto);
    }
}
