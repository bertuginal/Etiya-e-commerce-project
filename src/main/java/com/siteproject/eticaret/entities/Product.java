package com.siteproject.eticaret.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;
import java.util.List;

@Data // setter-getter alanı
@Builder
@Entity // Veritabanı ile bağlandığını belirtme alanı
@AllArgsConstructor //Oluşturulan fields'ların constructorı
@NoArgsConstructor // Hiç bir veri gelmese de kod çalışsın diye boş bir constructor
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "unit_price")
    private Integer unitPrice;

    @Column(name = "units_in_stock")
    private Integer unitsInStock;

    @Column(name = "unit_description")
    private String unitDescription;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "updated_date")
    private Date updatedDate;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @OneToMany(mappedBy = "product")
    List<CartProduct> cartProductList;






}
