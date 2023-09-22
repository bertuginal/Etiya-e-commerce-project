package com.siteproject.eticaret.services.district;

import com.siteproject.eticaret.core.utilities.result.Result;
import com.siteproject.eticaret.dtos.request.district.CreateDistrictDto;

public interface DistrictService {

    Result addDistrict(CreateDistrictDto createDistrictDto);
}
