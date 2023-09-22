package com.siteproject.eticaret.dtos.request.cart;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.criteria.CriteriaBuilder;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddProductToCartDto {

    @NotNull
    private Integer cartProductId;

}
