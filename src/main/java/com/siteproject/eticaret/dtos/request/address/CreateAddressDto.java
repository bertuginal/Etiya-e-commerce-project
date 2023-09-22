package com.siteproject.eticaret.dtos.request.address;

import com.siteproject.eticaret.entities.Customer;
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
public class CreateAddressDto {

    @NotEmpty
    private String addressName;

    @NotNull
    private int postalCode;

    @NotNull
    private int userId;

    @NotNull
    private int addressTypeId;

    @NotNull
    private int streetId;
}
