package com.siteproject.eticaret.services.city;

import com.siteproject.eticaret.core.utilities.result.Result;
import com.siteproject.eticaret.dtos.request.city.CreateCityDto;

public interface CityService {

    Result addCity(CreateCityDto createCityDto);
}
