package com.siteproject.eticaret.services.invoice;

import com.siteproject.eticaret.core.utilities.result.Result;
import com.siteproject.eticaret.dtos.request.invoice.CreateInvoiceDto;
import com.siteproject.eticaret.dtos.response.invoice.GetInvoiceDto;
import com.siteproject.eticaret.entities.Invoice;

public interface InvoiceService {

    Result<GetInvoiceDto> addInvoice(CreateInvoiceDto createInvoiceDto);
}
