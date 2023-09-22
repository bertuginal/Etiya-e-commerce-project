package com.siteproject.eticaret.services.address;

import com.siteproject.eticaret.core.utilities.result.Result;
import com.siteproject.eticaret.dtos.request.address.CreateAddressDto;
import com.siteproject.eticaret.dtos.request.address.DeleteAddressDto;

public interface AddressService {

    Result addAddress(CreateAddressDto createAddressDto);
/*    Result deleteAddress(DeleteAddressDto deleteAddressDto);*/
}
