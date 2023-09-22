package com.siteproject.eticaret.services.cart;

import com.siteproject.eticaret.core.utilities.exceptions.BusinessException;
import com.siteproject.eticaret.core.utilities.result.Result;
import com.siteproject.eticaret.dtos.request.cart.AddProductToCartDto;
import com.siteproject.eticaret.dtos.request.cart.CreateCartDto;
import com.siteproject.eticaret.dtos.request.cart.DeleteCartDto;
import com.siteproject.eticaret.dtos.request.cart.DeleteProductFromCartDto;
import com.siteproject.eticaret.entities.Cart;
import com.siteproject.eticaret.entities.CartProduct;
import com.siteproject.eticaret.entities.Customer;
import com.siteproject.eticaret.entities.Product;
import com.siteproject.eticaret.repositories.CartProductRepository;
import com.siteproject.eticaret.repositories.CartRepository;
import com.siteproject.eticaret.repositories.CustomerRepository;
import com.siteproject.eticaret.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CartManager implements CartService{

    private CartRepository cartRepository;
    private CustomerRepository customerRepository;

    @Override
    public Result addCart(CreateCartDto createCartDto) {
        Customer customer = customerRepository.findById(createCartDto.getCustomerId()).orElseThrow();
        Cart cartToAdd = Cart.builder()
                .customer(customer)
                .build();
        cartRepository.save(cartToAdd);
        return new Result(true, "Cart has been successfully added!");
    }

    @Override
    public Result deleteCart(DeleteCartDto deleteCartDto) {
        Cart cart = cartRepository.findById(deleteCartDto.getCartId()).orElseThrow();
        cartRepository.delete(cart);
        return new Result(true, "Cart has been successfully deleted!");
    }

}
