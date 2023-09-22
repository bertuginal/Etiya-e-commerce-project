package com.siteproject.eticaret.services.cart;

import com.siteproject.eticaret.core.utilities.result.Result;
import com.siteproject.eticaret.dtos.request.cart.AddProductToCartDto;
import com.siteproject.eticaret.dtos.request.cart.CreateCartDto;
import com.siteproject.eticaret.dtos.request.cart.DeleteCartDto;
import com.siteproject.eticaret.dtos.request.cart.DeleteProductFromCartDto;

public interface CartService {

    Result addCart(CreateCartDto createCartDto);
    Result deleteCart(DeleteCartDto deleteCartDto);


}
