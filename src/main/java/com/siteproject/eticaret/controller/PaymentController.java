package com.siteproject.eticaret.controller;

import com.siteproject.eticaret.core.utilities.result.Result;
import com.siteproject.eticaret.dtos.request.payment.CreatePaymentDto;
import com.siteproject.eticaret.services.payment.PaymentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/addpayment")
    public Result addPayment(@Valid @RequestBody CreatePaymentDto createPaymentDto) {
        return this.paymentService.addPayment(createPaymentDto);
    }
}
