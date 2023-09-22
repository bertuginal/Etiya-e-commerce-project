package com.siteproject.eticaret.dtos.request.payment;

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
public class CreatePaymentDto {

    @NotEmpty
    private String paymentDescription;

    @NotNull
    private int paymentTypeId;

    @NotNull
    private int userId;
}
