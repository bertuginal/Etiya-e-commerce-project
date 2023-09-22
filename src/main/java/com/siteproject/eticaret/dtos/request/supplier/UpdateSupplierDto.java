package com.siteproject.eticaret.dtos.request.supplier;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Email;
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
public class UpdateSupplierDto {

    @NotNull
    private Integer supplierId; //user id ye bağlı olduğu için supplier id kullanabiliriz

    @Nullable
    @Email
    private String userEmail;

    @Nullable
    private String userPassword;

    @Nullable
    @Size(min = 2)
    private String supplierName;
}
