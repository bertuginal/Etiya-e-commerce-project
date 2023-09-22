package com.siteproject.eticaret.services.address;

import com.siteproject.eticaret.core.utilities.exceptions.BusinessException;
import com.siteproject.eticaret.core.utilities.mapping.ModelMapperService;
import com.siteproject.eticaret.core.utilities.result.Result;
import com.siteproject.eticaret.dtos.request.address.CreateAddressDto;
import com.siteproject.eticaret.dtos.request.address.DeleteAddressDto;
import com.siteproject.eticaret.entities.*;
import com.siteproject.eticaret.repositories.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AddressManager implements AddressService{

    private AddressRepository addressRepository;
    private UserRepository userRepository;
    private ModelMapperService modelMapperService;
    private AddressTypeRepository addressTypeRepository;
    private StreetRepository streetRepository;

    @Override
    public Result addAddress(CreateAddressDto createAddressDto) {
        User user = userRepository.findById(createAddressDto.getUserId()).orElseThrow();
        AddressType addressType = addressTypeRepository.findById(createAddressDto.getAddressTypeId()).orElseThrow();
        Street street = streetRepository.findById(createAddressDto.getStreetId()).orElseThrow();
        Address addressToAdd = Address.builder()
                .addressName(createAddressDto.getAddressName())
                .postalCode(createAddressDto.getPostalCode())
                .addressType(addressType)
                .user(user)
                .street(street)
                .build();
        addressRepository.save(addressToAdd);
        return new Result(true,"Address has been successfully added!");
    }
}
