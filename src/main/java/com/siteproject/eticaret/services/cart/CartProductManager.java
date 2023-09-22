package com.siteproject.eticaret.services.cart;

import com.siteproject.eticaret.core.utilities.exceptions.BusinessException;
import com.siteproject.eticaret.core.utilities.result.Result;
import com.siteproject.eticaret.dtos.request.cart.AddProductToCartDto;
import com.siteproject.eticaret.dtos.request.cart.DeleteProductFromCartDto;
import com.siteproject.eticaret.entities.Cart;
import com.siteproject.eticaret.entities.CartProduct;
import com.siteproject.eticaret.entities.Product;
import com.siteproject.eticaret.repositories.CartProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CartProductManager implements CartProductService{

    private CartProductRepository cartProductRepository;

    @Override
    public Result addProductToCart(AddProductToCartDto addProductToCartDto) {
        CartProduct cartProduct = cartProductRepository.findById(addProductToCartDto.getCartProductId()).orElseThrow();
        checkIfUnitsInStock(cartProduct);
        cartProduct.setProductQuantity(cartProduct.getProductQuantity()+1);
        cartProductRepository.save(cartProduct);
        return new Result(true, "Product has been successfully added from your cart!");
    }

    @Override
    public Result deleteProductFromCart(DeleteProductFromCartDto deleteProductFromCartDto) {
        CartProduct cartProduct = cartProductRepository.findById(deleteProductFromCartDto.getCartProductId()).orElseThrow();
        cartProduct.setProductQuantity(cartProduct.getProductQuantity()-1);
        cartProductRepository.save(cartProduct);
        return new Result(true, "Product has been successfully deleted from your cart!");
    }



    private void checkIfUnitsInStock(CartProduct cartProduct) {
        if (cartProduct.getProduct().getUnitsInStock() < 0 || cartProduct.getProductQuantity() > cartProduct.getProduct().getUnitsInStock()) {
            throw new BusinessException("Product cannot be less than 0 and more than the cart quantity!");
        }
    }

}
