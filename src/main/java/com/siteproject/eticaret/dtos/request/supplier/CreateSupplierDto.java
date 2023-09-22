package com.siteproject.eticaret.dtos.request.supplier;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateSupplierDto {

    @NotEmpty
    @Size(min = 2)
    private String supplierName;

    @NotNull
    @Email
    private String userEmail;

    @NotNull
    private String userPassword;

}
