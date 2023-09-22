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
@Table(name = "payment_types")
public class PaymentType {

    @Id
    @GeneratedValue
    @Column(name = "payment_type_id")
    private Integer paymentTypeId;

    @Column(name = "payment_type_description")
    private String paymentTypeDescription;

    @OneToMany(mappedBy = "paymentType")
    List<Payment> paymentList;

//id, description
}
