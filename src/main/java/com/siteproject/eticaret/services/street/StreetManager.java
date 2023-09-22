package com.siteproject.eticaret.services.street;

import com.siteproject.eticaret.core.utilities.exceptions.BusinessException;
import com.siteproject.eticaret.core.utilities.result.Result;
import com.siteproject.eticaret.dtos.request.street.CreateStreetDto;
import com.siteproject.eticaret.entities.Avenue;
import com.siteproject.eticaret.entities.Street;
import com.siteproject.eticaret.repositories.AvenueRepository;
import com.siteproject.eticaret.repositories.StreetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StreetManager implements StreetService {

    private StreetRepository streetRepository;
    private AvenueRepository avenueRepository;

    @Override
    public Result addStreet(CreateStreetDto createStreetDto) {
        checkStreetName(createStreetDto.getStreetName());
        Avenue avenue = avenueRepository.findById(createStreetDto.getAvenueId()).orElseThrow();
        Street streetToAdd = Street.builder()
                .streetName(createStreetDto.getStreetName())
                .avenue(avenue)
                .build();
        streetRepository.save(streetToAdd);
        return new Result(true, "Street has been successfully added!");
    }

    private void checkStreetName(String streetName) {
        boolean ifExists = this.streetRepository.existsByStreetName(streetName);
        if (ifExists) {
            throw new BusinessException("Street already created!");
        }
    }
}
