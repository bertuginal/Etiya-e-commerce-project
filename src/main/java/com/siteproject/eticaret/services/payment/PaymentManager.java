package com.siteproject.eticaret.services.payment;

import com.siteproject.eticaret.core.utilities.result.Result;
import com.siteproject.eticaret.dtos.request.payment.CreatePaymentDto;
import com.siteproject.eticaret.dtos.request.payment.CreatePaymentTypeDto;
import com.siteproject.eticaret.entities.Payment;
import com.siteproject.eticaret.entities.PaymentType;
import com.siteproject.eticaret.entities.User;
import com.siteproject.eticaret.repositories.PaymentRepository;
import com.siteproject.eticaret.repositories.PaymentTypeRepository;
import com.siteproject.eticaret.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PaymentManager implements PaymentService {

    private PaymentRepository paymentRepository;
    private PaymentTypeRepository paymentTypeRepository;
    private UserRepository userRepository;

    @Override
    public Result addPayment(CreatePaymentDto createPaymentDto) {
        PaymentType paymentType = paymentTypeRepository.findById(createPaymentDto.getPaymentTypeId()).orElseThrow();
        User user = userRepository.findById(createPaymentDto.getUserId()).orElseThrow();
        Payment paymentToAdd = Payment.builder()
                .paymentDescription(createPaymentDto.getPaymentDescription())
                .paymentType(paymentType)
                .user(user)
                .build();
        paymentRepository.save(paymentToAdd);
        return new Result(true, "Payment has been successfully added!");
    }
}
