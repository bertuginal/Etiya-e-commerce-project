package com.siteproject.eticaret.dtos.response.product;

import com.siteproject.eticaret.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProductsDto {

    private String productName;
    private Integer unitPrice;
    private Integer unitsInStock;
    private String unitDescription;
    private Boolean isActive;
    private Date createdDate;
    private Date updatedDate;
    private Integer categoryId;
}
