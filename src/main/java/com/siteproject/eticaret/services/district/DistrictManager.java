package com.siteproject.eticaret.services.district;

import com.siteproject.eticaret.core.utilities.exceptions.BusinessException;
import com.siteproject.eticaret.core.utilities.result.Result;
import com.siteproject.eticaret.dtos.request.district.CreateDistrictDto;
import com.siteproject.eticaret.entities.City;
import com.siteproject.eticaret.entities.District;
import com.siteproject.eticaret.repositories.CityRepository;
import com.siteproject.eticaret.repositories.DistrictRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DistrictManager implements DistrictService {

    private CityRepository cityRepository;
    private DistrictRepository districtRepository;
    @Override
    public Result addDistrict(CreateDistrictDto createDistrictDto) {
        checkDistrictName(createDistrictDto.getDistrictName());
        City city = cityRepository.findById(createDistrictDto.getCityId()).orElseThrow();
        District districtToAdd = District.builder()
                .districtName(createDistrictDto.getDistrictName())
                .city(city)
                .build();
        districtRepository.save(districtToAdd);
        return new Result(true, "District has been successfully added!");
    }

    private void checkDistrictName(String districtName) {
        boolean ifExists = this.districtRepository.existsByDistrictName(districtName);
        if (ifExists) {
            throw new BusinessException("District already created!");
        }
    }
}
