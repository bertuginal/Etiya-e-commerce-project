package com.siteproject.eticaret.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customers")
@PrimaryKeyJoinColumn(name = "customer_id", referencedColumnName = "user_id")
public class Customer extends User {

    @Column(name = "customer_id", insertable = false, updatable = false) //insertable ve updatable --> sağdan ve soldan birşey gelmesin diye
    private Integer customerId;

    @Column(name = "customer_name")
    private String customerName;

    @OneToMany(mappedBy = "customer")
    List<Cart> cartList;

}
