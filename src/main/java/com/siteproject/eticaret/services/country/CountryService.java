package com.siteproject.eticaret.services.country;

import com.siteproject.eticaret.core.utilities.result.Result;
import com.siteproject.eticaret.dtos.request.country.CreateCountryDto;

public interface CountryService {

    Result addCountry(CreateCountryDto createCountryDto);
}
