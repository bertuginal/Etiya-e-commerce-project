package com.siteproject.eticaret.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ValueGenerationType;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "carts")
public class Cart implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cart_id")
    private Integer cartId;

    @OneToMany(mappedBy = "cart")
    List<CartProduct> cartProductList;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;





    //id,product, *product'ın supplier*, customer, quantity
}