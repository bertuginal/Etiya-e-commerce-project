package com.siteproject.eticaret.dtos.response.category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetCategoryByIdDto {

    private Integer categoryId;
    private String categoryName;
}
