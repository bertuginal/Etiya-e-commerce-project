package com.siteproject.eticaret.dtos.request.district;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateDistrictDto {

    @NotEmpty
    private String districtName;

    @NotNull
    private Integer cityId;
}
