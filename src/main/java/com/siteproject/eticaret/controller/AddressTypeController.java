package com.siteproject.eticaret.controller;

import com.siteproject.eticaret.core.utilities.result.Result;
import com.siteproject.eticaret.dtos.request.address.CreateAddressTypeDto;
import com.siteproject.eticaret.services.address.AddressTypeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/addresstypes")
public class AddressTypeController {

    @Autowired
    private AddressTypeService addressTypeService;

    @PostMapping("/addaddresstype")
    public Result addAdressType(@Valid @RequestBody CreateAddressTypeDto createAddressTypeDto) {
        return this.addressTypeService.addAdressType(createAddressTypeDto);
    }
}
