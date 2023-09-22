package com.siteproject.eticaret.controller;

import com.siteproject.eticaret.core.utilities.result.Result;
import com.siteproject.eticaret.dtos.request.invoice.CreateInvoiceDto;
import com.siteproject.eticaret.dtos.response.invoice.GetInvoiceDto;
import com.siteproject.eticaret.entities.Invoice;
import com.siteproject.eticaret.services.invoice.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/invoices")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @PostMapping("/addinvoice")
    public Result<GetInvoiceDto> addInvoice(@RequestBody CreateInvoiceDto createInvoiceDto) {
        return this.invoiceService.addInvoice(createInvoiceDto);
    }
}
