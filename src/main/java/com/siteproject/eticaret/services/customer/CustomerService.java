package com.siteproject.eticaret.services.customer;


import com.siteproject.eticaret.core.utilities.result.Result;
import com.siteproject.eticaret.dtos.request.customer.CreateCustomerDto;
import com.siteproject.eticaret.dtos.request.customer.DeleteCustomerDto;
import com.siteproject.eticaret.dtos.request.customer.UpdateCustomerDto;
import com.siteproject.eticaret.dtos.response.customer.GetAllCustomersDto;
import com.siteproject.eticaret.dtos.response.customer.GetCustomerByIdDto;

import java.util.List;

public interface CustomerService {

    Result addCustomer(CreateCustomerDto createCustomerDto);
    Result deleteCustomer(DeleteCustomerDto deleteCustomerDto);
    Result updateCustomer(UpdateCustomerDto updateCustomerDto);
    Result<GetCustomerByIdDto> getCustomerById(GetCustomerByIdDto getCustomerByIdDto);
    Result<List<GetAllCustomersDto>> getAllCustomers();
}
