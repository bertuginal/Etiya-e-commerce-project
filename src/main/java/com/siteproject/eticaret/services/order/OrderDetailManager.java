package com.siteproject.eticaret.services.order;

import com.siteproject.eticaret.core.utilities.result.Result;
import com.siteproject.eticaret.dtos.request.order.CreateOrderDetailDto;
import com.siteproject.eticaret.entities.*;
import com.siteproject.eticaret.repositories.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderDetailManager implements OrderDetailService {

    private OrderDetailRepository orderDetailRepository;
    private CartProductRepository cartProductRepository;
    private ProductRepository productRepository;

    @Override
    public Result addOrderDetail(CreateOrderDetailDto createOrderDetailDto) {

        List<CartProduct> cartProductList = cartProductRepository.findById(createOrderDetailDto.getCartId()).stream().toList(); //cartId ile bulunacak.
        OrderDetail orderDetailToAdd = OrderDetail.builder()
                .orderDescription(createOrderDetailDto.getOrderDescription())
                .cartProductList(cartProductList)
                .orderTotalPrice(calculateTotalPrice(cartProductList))
                .build();
        orderDetailRepository.save(orderDetailToAdd);
        return new Result(true, "Order Detail has been successfully added!");
    }

    private int calculateTotalPrice(List<CartProduct> cartProductList) {
        int totalPrice = 0;
        for (CartProduct cartProduct : cartProductList) {
            totalPrice += cartProduct.getProduct().getUnitPrice() * cartProduct.getProductQuantity();
        }
        return totalPrice;
    }

//Complete: address bağlantısı userid olacak, unitsinstock eksi ve sepetteki üründen fazla olamaz, aynı category eklenmemeli, countries-cities... aynı giremez, aynı mail ile kayıt olmamalı
//TODO: fatura oluşacak -> T olarak data fatura no ve sipariş no dönecek
// TODO: fatura içerisinde bulunan adres, order ve cart product'ı customer üzerinden yap. bunu repo da query ile yazabilirsin.
    //TODO: fatura adresi,sipariş adresi --> address
    //TODO: sipraiş tarihi,total price --> order
    //TODO: ürün, ürün adedi, ürün adet fiyatı --> cartproduct
}

