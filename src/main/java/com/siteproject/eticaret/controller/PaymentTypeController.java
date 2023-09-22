package com.siteproject.eticaret.controller;

import com.siteproject.eticaret.core.utilities.result.Result;
import com.siteproject.eticaret.dtos.request.payment.CreatePaymentTypeDto;
import com.siteproject.eticaret.services.payment.PaymentTypeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/paymenttypes")
public class PaymentTypeController {

    @Autowired
    private PaymentTypeService paymentTypeService;

    @PostMapping("/addpaymenttype")
    public Result addPaymentType(@Valid @RequestBody CreatePaymentTypeDto createPaymentTypeDto) {
        return this.paymentTypeService.addPaymentType(createPaymentTypeDto);
    }
}
