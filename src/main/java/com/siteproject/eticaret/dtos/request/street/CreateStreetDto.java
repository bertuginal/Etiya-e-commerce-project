package com.siteproject.eticaret.dtos.request.street;

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
public class CreateStreetDto {

    @NotEmpty
    private String streetName;

    @NotNull
    private Integer avenueId;
}
