package com.siteproject.eticaret.controller;

import com.siteproject.eticaret.core.utilities.result.Result;
import com.siteproject.eticaret.dtos.request.cart.AddProductToCartDto;
import com.siteproject.eticaret.dtos.request.cart.CreateCartDto;
import com.siteproject.eticaret.dtos.request.cart.DeleteCartDto;
import com.siteproject.eticaret.dtos.request.cart.DeleteProductFromCartDto;
import com.siteproject.eticaret.services.cart.CartService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/carts")
public class CartController {


    @Autowired
    private CartService cartService;
    @PostMapping("/addcart")
    public Result addCart(@Valid @RequestBody CreateCartDto createCartDto) {
        return this.cartService.addCart(createCartDto);
    }

    @DeleteMapping("/deletecart")
    public Result deleteCart(@Valid @RequestBody DeleteCartDto deleteCartDto) {
        return this.cartService.deleteCart(deleteCartDto);
    }





}
