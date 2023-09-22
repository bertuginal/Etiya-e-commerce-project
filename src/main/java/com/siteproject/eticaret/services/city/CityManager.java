package com.siteproject.eticaret.services.city;

import com.siteproject.eticaret.core.utilities.exceptions.BusinessException;
import com.siteproject.eticaret.core.utilities.result.Result;
import com.siteproject.eticaret.dtos.request.city.CreateCityDto;
import com.siteproject.eticaret.entities.City;
import com.siteproject.eticaret.entities.Country;
import com.siteproject.eticaret.repositories.CityRepository;
import com.siteproject.eticaret.repositories.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CityManager implements CityService {

    private CityRepository cityRepository;
    private CountryRepository countryRepository;
    @Override
    public Result addCity(CreateCityDto createCityDto) {
        checkCityName(createCityDto.getCityName());
        Country country = countryRepository.findById(createCityDto.getCountryId()).orElseThrow();
        City cityToAdd = City.builder()
                .cityName(createCityDto.getCityName())
                .country(country)
                .build();
        cityRepository.save(cityToAdd);
        return new Result(true, "City has been successfully added!");
    }

    private void checkCityName(String cityName) {
        boolean ifExists = this.cityRepository.existsByCityName(cityName);
        if (ifExists) {
            throw new BusinessException("City already created!");
        }
    }
}
