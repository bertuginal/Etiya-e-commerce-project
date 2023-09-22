package com.siteproject.eticaret.dtos.request.customer;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCustomerDto {

    @NotNull
    private Integer customerId;

    @Nullable
    @Email
    private String userEmail;

    @Nullable
    private String userPassword;

    @Nullable
    @Size(min = 2)
    private String customerName;

}
