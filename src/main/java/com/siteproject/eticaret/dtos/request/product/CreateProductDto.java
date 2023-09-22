package com.siteproject.eticaret.dtos.request.product;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductDto {

    @NotEmpty
    @Size(min = 2)
    private String productName;

    @NotNull
    @Positive
    @Min(value = 1, message = "Product price cannot be less than 1!")
    @Max(value = 100000, message = "Product price cannot be more than 100000!")
    private Integer unitPrice;

    @NotNull
    @Positive
    @Min(value = 10, message = "Stock status cannot be less than 10!")
    @Max(value = 10000, message = "Stock status cannot be more than 10000!")
    private Integer unitsInStock;

    @NotBlank
    @Size(min = 10, max = 300, message = "Product description must be between 10 and 300 characters!")
    private String unitDescription;

    @NotNull
    private Integer categoryId;

    @NotNull
    private Integer supplierId;

}
