package com.siteproject.eticaret.services.payment;

import com.siteproject.eticaret.core.utilities.result.Result;
import com.siteproject.eticaret.dtos.request.payment.CreatePaymentDto;

public interface PaymentService {

    Result addPayment(CreatePaymentDto createPaymentDto);
}
