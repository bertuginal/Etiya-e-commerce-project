package com.siteproject.eticaret.services.order;

import com.siteproject.eticaret.core.utilities.result.Result;
import com.siteproject.eticaret.dtos.request.order.CreateOrderDetailDto;

public interface OrderDetailService {

    Result addOrderDetail(CreateOrderDetailDto createOrderDetailDto);

}
