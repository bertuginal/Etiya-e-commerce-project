package com.siteproject.eticaret.dtos.request.product;

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
public class UpdateProductDto {

    @NotNull
    private Integer productId;

    @Nullable
    @Size(min = 2)
    private String productName;

    @Nullable
    @Positive
    @Min(value = 1, message = "Product price cannot be less than 1!")
    @Max(value = 10000, message = "Product price cannot be more than 10000!")
    private Integer unitPrice;

    @Nullable
    @Positive
    @Min(value = 10, message = "Stock status cannot be less than 10!")
    @Max(value = 100, message = "Stock status cannot be more than 100!")
    private Integer unitsInStock;

    @Nullable
    @Size(min = 10, max = 300, message = "Product description must be between 10 and 300 characters!")
    private String unitDescription;

    @Nullable
    private Integer categoryId;


}
