package com.siteproject.eticaret.services.address;

import com.siteproject.eticaret.core.utilities.result.Result;
import com.siteproject.eticaret.dtos.request.address.CreateAddressTypeDto;

public interface AddressTypeService {
    Result addAdressType(CreateAddressTypeDto createAddressTypeDto);
}
