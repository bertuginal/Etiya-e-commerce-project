package com.siteproject.eticaret.dtos.response.supplier;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetSupplierByIdDto {

    private Integer supplierId;
    private String userEmail;
    private String userPassword;
    private Boolean isActive;
    private Date createdDate;
    private Date updatedDate;

}
