package com.siteproject.eticaret.dtos.request.order;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderDto {

    @NotNull
    private int paymentId;

    @NotNull
    private int orderDetailId;

}
