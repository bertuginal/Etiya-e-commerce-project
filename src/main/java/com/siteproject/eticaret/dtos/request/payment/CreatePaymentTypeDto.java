package com.siteproject.eticaret.dtos.request.payment;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreatePaymentTypeDto {

    @NotEmpty
    private String paymentTypeDescription;
}
