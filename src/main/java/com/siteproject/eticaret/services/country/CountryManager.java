package com.siteproject.eticaret.services.country;

import com.siteproject.eticaret.core.utilities.exceptions.BusinessException;
import com.siteproject.eticaret.core.utilities.result.Result;
import com.siteproject.eticaret.dtos.request.country.CreateCountryDto;
import com.siteproject.eticaret.entities.Country;
import com.siteproject.eticaret.repositories.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CountryManager implements CountryService {

    private CountryRepository countryRepository;
    @Override
    public Result addCountry(CreateCountryDto createCountryDto) {
        checkCountryName(createCountryDto.getCountryName());
        Country countryToAdd = Country.builder()
                .countryName(createCountryDto.getCountryName())
                .build();
        countryRepository.save(countryToAdd);
        return new Result(true, "Country has been successfully added!");
    }

    private void checkCountryName(String countryName) {
        boolean ifExists = this.countryRepository.existsByCountryName(countryName);
        if (ifExists) {
            throw new BusinessException("Country already created!");
        }
    }
}
