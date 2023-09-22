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
@Table(name = "address_types")
public class AddressType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_type_id")
    private int addressTypeId;

    @Column(name = "address_type_description")
    private String addressTypeDescription;

    @OneToMany(mappedBy = "addressType")
    List<Address> addressList;
}
