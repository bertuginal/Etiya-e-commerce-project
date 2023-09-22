package com.siteproject.eticaret.dtos.request.avenue;

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
public class CreateAvenueDto {

    @NotEmpty
    private String avenueName;

    @NotNull
    private Integer districtId;
}
