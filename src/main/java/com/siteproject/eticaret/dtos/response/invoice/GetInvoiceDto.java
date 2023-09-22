package com.siteproject.eticaret.dtos.response.invoice;

import com.siteproject.eticaret.entities.Address;
import com.siteproject.eticaret.entities.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetInvoiceDto {

    private String invoiceNumber;
    private String addressName;
    private Integer totalPrice;
    private Date orderDate;

}
