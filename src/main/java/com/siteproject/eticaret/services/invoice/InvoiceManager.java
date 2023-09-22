package com.siteproject.eticaret.services.invoice;

import com.siteproject.eticaret.core.utilities.result.Result;
import com.siteproject.eticaret.dtos.request.invoice.CreateInvoiceDto;
import com.siteproject.eticaret.dtos.response.invoice.GetInvoiceDto;
import com.siteproject.eticaret.entities.*;
import com.siteproject.eticaret.repositories.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class InvoiceManager implements InvoiceService {

    private InvoiceRepository invoiceRepository;
    private CartProductRepository cartProductRepository;
    private CustomerRepository customerRepository;
    private AddressRepository addressRepository;
    private OrderRepository orderRepository;

    @Override
    public Result<GetInvoiceDto> addInvoice(CreateInvoiceDto createInvoiceDto) {
        Random random = new Random();
        Integer randomNumber = random.nextInt(99999, 1000000);
        Order order = orderRepository.findById(createInvoiceDto.getOrderId()).orElseThrow();
        Address address = addressRepository.findById(createInvoiceDto.getAddressId()).orElseThrow();
        Invoice invoiceToAdd = Invoice.builder()
                .invoiceDescription(createInvoiceDto.getInvoiceDescription())
                .address(address)
                .order(order)
                .invoiceNumber(randomNumber.toString())
                .build();
        invoiceRepository.save(invoiceToAdd);
        GetInvoiceDto getInvoiceDto = GetInvoiceDto.builder()
                .invoiceNumber(randomNumber.toString())
                .addressName(address.getAddressName())
                .orderDate(order.getOrderDate())
                .totalPrice(order.getOrderDetail().getOrderTotalPrice())
                .build();
        return new Result<GetInvoiceDto>(true, getInvoiceDto);
    }

}
