package com.siteproject.eticaret.services.avenue;

import com.siteproject.eticaret.core.utilities.exceptions.BusinessException;
import com.siteproject.eticaret.core.utilities.result.Result;
import com.siteproject.eticaret.dtos.request.avenue.CreateAvenueDto;
import com.siteproject.eticaret.entities.Avenue;
import com.siteproject.eticaret.entities.District;
import com.siteproject.eticaret.repositories.AvenueRepository;
import com.siteproject.eticaret.repositories.DistrictRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AvenueManager implements AvenueService {

    private AvenueRepository avenueRepository;
    private DistrictRepository districtRepository;
    @Override
    public Result addAvenue(CreateAvenueDto createAvenueDto) {
        checkAvenueName(createAvenueDto.getAvenueName());
        District district = districtRepository.findById(createAvenueDto.getDistrictId()).orElseThrow();
        Avenue avenueToAdd = Avenue.builder()
                .avenueName(createAvenueDto.getAvenueName())
                .district(district)
                .build();
        avenueRepository.save(avenueToAdd);
        return new Result(true, "Avenue has been successfully added!");
    }

    private void checkAvenueName(String avenueName) {
        boolean ifExists = this.avenueRepository.existsByAvenueName(avenueName);
        if (ifExists) {
            throw new BusinessException("Avenue already created!");
        }
    }
}
