package com.siteproject.eticaret.controller;

import com.siteproject.eticaret.core.utilities.result.Result;
import com.siteproject.eticaret.dtos.request.street.CreateStreetDto;
import com.siteproject.eticaret.services.street.StreetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/streets")
public class StreetController {

    @Autowired
    private StreetService streetService;
    @PostMapping("/addstreet")
    public Result addStreet(@Valid @RequestBody CreateStreetDto createStreetDto) {
        return this.streetService.addStreet(createStreetDto);
    }
}
