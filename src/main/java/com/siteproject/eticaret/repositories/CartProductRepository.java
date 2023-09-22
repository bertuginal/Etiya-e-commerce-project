package com.siteproject.eticaret.repositories;

import com.siteproject.eticaret.entities.CartProduct;
import com.siteproject.eticaret.entities.Product;
import com.siteproject.eticaret.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartProductRepository extends JpaRepository<CartProduct, Integer> {
    @Query("select cp from CartProduct cp join cp.cart c where c.cartId = :cartId")
    List<CartProduct> findByCartId(int cartId);

}
