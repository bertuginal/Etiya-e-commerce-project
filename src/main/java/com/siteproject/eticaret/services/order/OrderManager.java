package com.siteproject.eticaret.services.order;

import com.siteproject.eticaret.core.utilities.result.Result;
import com.siteproject.eticaret.dtos.request.order.CreateOrderDto;
import com.siteproject.eticaret.entities.*;
import com.siteproject.eticaret.repositories.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderManager implements OrderService {

    private OrderRepository orderRepository;
    private PaymentRepository paymentRepository;
    private OrderDetailRepository orderDetailRepository;

    @Override
    public Result addOrder(CreateOrderDto createOrderDto) {
        Payment payment = paymentRepository.findById(createOrderDto.getPaymentId()).orElseThrow();
        OrderDetail orderDetail = orderDetailRepository.findById(createOrderDto.getOrderDetailId()).orElseThrow();
        Order orderToAdd = Order.builder()
                .payment(payment)
                .orderDetail(orderDetail)
                .orderDate(new Date())
                .orderConfirmation(true)
                .build();
        orderRepository.save(orderToAdd);
        return new Result(true, "Order has been successfully added!");
    }
}
