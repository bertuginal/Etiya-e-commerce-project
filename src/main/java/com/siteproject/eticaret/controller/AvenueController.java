package com.siteproject.eticaret.controller;

import com.siteproject.eticaret.core.utilities.result.Result;
import com.siteproject.eticaret.dtos.request.avenue.CreateAvenueDto;
import com.siteproject.eticaret.services.avenue.AvenueService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/avenues")
public class AvenueController {

    @Autowired
    private AvenueService avenueService;

    @PostMapping("addavenue")
    public Result addAvenue(@Valid @RequestBody CreateAvenueDto createAvenueDto) {
        return this.avenueService.addAvenue(createAvenueDto);
    }
}
