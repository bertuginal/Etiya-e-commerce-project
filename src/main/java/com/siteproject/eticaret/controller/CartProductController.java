package com.siteproject.eticaret.controller;

import com.siteproject.eticaret.core.utilities.result.Result;
import com.siteproject.eticaret.dtos.request.cart.AddProductToCartDto;
import com.siteproject.eticaret.dtos.request.cart.DeleteProductFromCartDto;
import com.siteproject.eticaret.services.cart.CartProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/cartproducts")
public class CartProductController {

    @Autowired
    private CartProductService cartProductService;

    @PutMapping("/addproducttocart")
    public Result addProductToCart(@Valid @RequestBody AddProductToCartDto addProductToCartDto) {
        return this.cartProductService.addProductToCart(addProductToCartDto);
    }

    @PutMapping("/deleteproductfromcart")
    public Result deleteProductFromCart(@Valid @RequestBody DeleteProductFromCartDto deleteProductFromCartDto) {
        return this.cartProductService.deleteProductFromCart(deleteProductFromCartDto);
    }
}
