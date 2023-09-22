package com.siteproject.eticaret.services.payment;

import com.siteproject.eticaret.core.utilities.result.Result;
import com.siteproject.eticaret.dtos.request.payment.CreatePaymentTypeDto;
import com.siteproject.eticaret.entities.PaymentType;
import com.siteproject.eticaret.repositories.PaymentTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PaymentTypeManager implements PaymentTypeService {

    private PaymentTypeRepository paymentTypeRepository;
    @Override
    public Result addPaymentType(CreatePaymentTypeDto createPaymentTypeDto) {
        PaymentType paymentTypeToAdd = PaymentType.builder()
                .paymentTypeDescription(createPaymentTypeDto.getPaymentTypeDescription())
                .build();
        paymentTypeRepository.save(paymentTypeToAdd);
        return new Result(true, "Payment Type has been successfully added!");
    }
}
