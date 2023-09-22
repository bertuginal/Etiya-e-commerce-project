package com.siteproject.eticaret.services.payment;

import com.siteproject.eticaret.core.utilities.result.Result;
import com.siteproject.eticaret.dtos.request.payment.CreatePaymentTypeDto;

public interface PaymentTypeService {

    Result addPaymentType(CreatePaymentTypeDto createPaymentTypeDto);
}
