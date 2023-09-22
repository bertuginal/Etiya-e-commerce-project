package com.siteproject.eticaret.controller;

import com.siteproject.eticaret.core.utilities.result.Result;
import com.siteproject.eticaret.dtos.request.address.CreateAddressDto;
import com.siteproject.eticaret.services.address.AddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/adresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("/addaddress")
    public Result addAddress(@Valid @RequestBody CreateAddressDto createAddressDto) {
        return this.addressService.addAddress(createAddressDto);
    }
}
