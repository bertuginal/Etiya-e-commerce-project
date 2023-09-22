package com.siteproject.eticaret.dtos.request.invoice;

import com.siteproject.eticaret.entities.Address;
import com.siteproject.eticaret.entities.Order;
import com.siteproject.eticaret.entities.OrderDetail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateInvoiceDto {

    private String invoiceDescription;
    private Integer addressId;
    private Integer orderId;


}
