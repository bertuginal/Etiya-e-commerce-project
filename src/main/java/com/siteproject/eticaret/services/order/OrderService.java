package com.siteproject.eticaret.services.order;

import com.siteproject.eticaret.core.utilities.result.Result;
import com.siteproject.eticaret.dtos.request.order.CreateOrderDto;

public interface OrderService {

    Result addOrder(CreateOrderDto createOrderDto);
}
