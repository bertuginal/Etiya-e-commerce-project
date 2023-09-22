package com.siteproject.eticaret.services.customer;

import com.siteproject.eticaret.core.utilities.exceptions.BusinessException;
import com.siteproject.eticaret.core.utilities.mapping.ModelMapperService;
import com.siteproject.eticaret.core.utilities.result.Result;
import com.siteproject.eticaret.dtos.request.customer.CreateCustomerDto;
import com.siteproject.eticaret.dtos.request.customer.DeleteCustomerDto;
import com.siteproject.eticaret.dtos.request.customer.UpdateCustomerDto;
import com.siteproject.eticaret.dtos.response.customer.GetAllCustomersDto;
import com.siteproject.eticaret.dtos.response.customer.GetCustomerByIdDto;
import com.siteproject.eticaret.entities.Customer;
import com.siteproject.eticaret.entities.Product;
import com.siteproject.eticaret.entities.User;
import com.siteproject.eticaret.repositories.CustomerRepository;
import com.siteproject.eticaret.repositories.UserRepository;
import com.siteproject.eticaret.services.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService{

    private ModelMapperService modelMapperService;
    private CustomerRepository customerRepository;

    @Override
    public Result addCustomer(CreateCustomerDto createCustomerDto) {
        Customer customer = this.modelMapperService.forRequest().map(createCustomerDto, Customer.class);
        checkUserEmail(customer.getUserEmail());
        customer.setIsActive(true);
        customer.setCreatedDate(new Date());
        customerRepository.save(customer);
        return new Result(true, "Customer has been successfully added!");
    }

    @Override
    public Result deleteCustomer(DeleteCustomerDto deleteCustomerDto) {
        Customer customer = customerRepository.findById(deleteCustomerDto.getUserId()).orElseThrow();
        checkIfCustomerActive(customer);
        customer.setIsActive(false);
        customer.setCreatedDate(customer.getCreatedDate());
        customer.setUpdatedDate(new Date());
        customerRepository.save(customer);
        return new Result(true, "Customer has been sucessfully deleted!");
    }

    @Override
    public Result updateCustomer(UpdateCustomerDto updateCustomerDto) {
        Customer customer = customerRepository.findById(updateCustomerDto.getCustomerId()).orElseThrow();
        customer.setIsActive(false);
        customerRepository.save(customer);

        Customer customerToUpdate = this.modelMapperService.forRequest().map(updateCustomerDto, Customer.class);
        customerToUpdate.setIsActive(true);
        customerToUpdate.setCreatedDate(customer.getCreatedDate());
        customerToUpdate.setUpdatedDate(new Date());
        customerRepository.save(customerToUpdate);
        return new Result(true, "Customer has been successfully updated!");
    }

    @Override
    public Result<GetCustomerByIdDto> getCustomerById(GetCustomerByIdDto getCustomerByIdDto) {
        Customer customerId = customerRepository.findById(getCustomerByIdDto.getCustomerId()).orElseThrow();
        GetCustomerByIdDto response = modelMapperService.forResponse().map(customerId, GetCustomerByIdDto.class);
        return new Result<GetCustomerByIdDto>(true, response);
    }

    @Override
    public Result<List<GetAllCustomersDto>> getAllCustomers() {
        List<Customer> customerList = customerRepository.findAll();
        List<GetAllCustomersDto> response = customerList.stream().map(customer -> modelMapperService.forResponse().map(customer, GetAllCustomersDto.class)).collect(Collectors.toList());
        return new Result<List<GetAllCustomersDto>>(true, response);
    }

    private void checkIfCustomerActive(Customer customer) {
        if (customer.getIsActive() == false){
            throw new BusinessException("Customer already disabled!");
        }
    }
    private void checkUserEmail(String userEmail) {
        boolean ifExists = this.customerRepository.existsByUserEmail(userEmail);
        if(ifExists){
            throw new BusinessException("Customer email already created!");
        }
    }
}
