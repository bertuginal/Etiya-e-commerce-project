package com.siteproject.eticaret.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_details")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_details_id")
    private Integer orderDetailsId;

    @Column(name = "order_total_price")
    private int orderTotalPrice;

    @Column(name = "order_description")
    private String orderDescription;

    @OneToMany(mappedBy = "orderDetail")
    List<CartProduct> cartProductList;

    @OneToMany(mappedBy = "orderDetail")
    List<Order> orderList;



}
