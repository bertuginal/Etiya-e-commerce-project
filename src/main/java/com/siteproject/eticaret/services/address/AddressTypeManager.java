package com.siteproject.eticaret.services.address;

import com.siteproject.eticaret.core.utilities.result.Result;
import com.siteproject.eticaret.dtos.request.address.CreateAddressTypeDto;
import com.siteproject.eticaret.entities.Address;
import com.siteproject.eticaret.entities.AddressType;
import com.siteproject.eticaret.repositories.AddressRepository;
import com.siteproject.eticaret.repositories.AddressTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddressTypeManager implements AddressTypeService {

    private AddressTypeRepository addressTypeRepository;
    private AddressRepository addressRepository;

    @Override
    public Result addAdressType(CreateAddressTypeDto createAddressTypeDto) {

        AddressType addressTypeToAdd = AddressType.builder()
                .addressTypeDescription(createAddressTypeDto.getAddressTypeDescription())
                .build();
        addressTypeRepository.save(addressTypeToAdd);
        return new Result(true, "Address Type has been successfully added!");
    }
}
