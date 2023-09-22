package com.siteproject.eticaret.controller;

import com.siteproject.eticaret.core.utilities.result.Result;
import com.siteproject.eticaret.dtos.request.customer.CreateCustomerDto;
import com.siteproject.eticaret.dtos.request.customer.DeleteCustomerDto;
import com.siteproject.eticaret.dtos.request.customer.UpdateCustomerDto;
import com.siteproject.eticaret.dtos.response.customer.GetAllCustomersDto;
import com.siteproject.eticaret.dtos.response.customer.GetCustomerByIdDto;
import com.siteproject.eticaret.services.customer.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/addcustomer")
    public Result addCustomer(@Valid @RequestBody CreateCustomerDto createCustomerDto) {
        return this.customerService.addCustomer(createCustomerDto);
    }

    @PutMapping("/deletecustomer")
    public Result deleteCustomer(@Valid @RequestBody DeleteCustomerDto deleteCustomerDto) {
        return this.customerService.deleteCustomer(deleteCustomerDto);
    }

    @PutMapping("/updatecustomer")
    public Result updateCustomer(@Valid @RequestBody UpdateCustomerDto updateCustomerDto) {
        return this.customerService.updateCustomer(updateCustomerDto);
    }

    @GetMapping("/getcustomerbyid")
    public Result<GetCustomerByIdDto> getCustomerById(@RequestBody GetCustomerByIdDto getCustomerByIdDto) {
        return this.customerService.getCustomerById(getCustomerByIdDto);
    }

    @GetMapping("getallcustomers")
    public Result<List<GetAllCustomersDto>> getAllCustomers() {
        return this.customerService.getAllCustomers();
    }

}

