package com.siteproject.eticaret.controller;

import com.siteproject.eticaret.core.utilities.result.Result;
import com.siteproject.eticaret.dtos.request.order.CreateOrderDetailDto;
import com.siteproject.eticaret.services.order.OrderDetailService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/orderdetails")
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;
    @PostMapping("/addorderdetail")
    public Result addOrderDetail(@Valid @RequestBody CreateOrderDetailDto createOrderDetailDto) {
        return this.orderDetailService.addOrderDetail(createOrderDetailDto);
    }
}
