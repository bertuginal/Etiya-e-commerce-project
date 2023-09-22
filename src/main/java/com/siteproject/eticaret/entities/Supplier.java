package com.siteproject.eticaret.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "suppliers")
@PrimaryKeyJoinColumn(name = "supplier_id", referencedColumnName = "user_id")
public class Supplier extends User{


    @Column(name = "supplier_id", insertable = false, updatable = false)
    private int supplierId;

    @Column(name = "supplier_name")
    private String supplierName;

    @OneToMany(mappedBy = "supplier")
    List<Product> product;




}
