package com.siteproject.eticaret.services.avenue;

import com.siteproject.eticaret.core.utilities.result.Result;
import com.siteproject.eticaret.dtos.request.avenue.CreateAvenueDto;

public interface AvenueService {

    Result addAvenue(CreateAvenueDto createAvenueDto);
}
