package com.siteproject.eticaret.services.street;

import com.siteproject.eticaret.core.utilities.result.Result;
import com.siteproject.eticaret.dtos.request.street.CreateStreetDto;

public interface StreetService {

    Result addStreet(CreateStreetDto createStreetDto);
}
