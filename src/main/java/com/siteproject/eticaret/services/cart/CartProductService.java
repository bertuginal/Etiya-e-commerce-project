package com.siteproject.eticaret.services.cart;

import com.siteproject.eticaret.core.utilities.result.Result;
import com.siteproject.eticaret.dtos.request.cart.AddProductToCartDto;
import com.siteproject.eticaret.dtos.request.cart.DeleteProductFromCartDto;

public interface CartProductService {

    Result addProductToCart(AddProductToCartDto addProductToCartDto);
    Result deleteProductFromCart(DeleteProductFromCartDto deleteProductFromCartDto);
}
