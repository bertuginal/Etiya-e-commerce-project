package com.siteproject.eticaret.controller;

import com.siteproject.eticaret.core.utilities.result.Result;
import com.siteproject.eticaret.dtos.request.district.CreateDistrictDto;
import com.siteproject.eticaret.services.district.DistrictService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/districts")
public class DistrictController {

    @Autowired
    private DistrictService districtService;

    @PostMapping("/adddistrict")
    public Result addDistrict(@Valid @RequestBody CreateDistrictDto createDistrictDto) {
        return this.districtService.addDistrict(createDistrictDto);
    }
}
