package com.siteproject.eticaret.repositories;

import com.siteproject.eticaret.core.utilities.result.Result;
import com.siteproject.eticaret.dtos.response.product.GetAllProductsDto;
import com.siteproject.eticaret.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {


    @Query("select new com.siteproject.eticaret.dtos.response.product.GetAllProductsDto(p.productName, p.unitPrice, p.unitsInStock, p.unitDescription, p.isActive, p.createdDate, p.updatedDate, c.categoryId) from Product as p join p.category c where c.isActive = false")
    List<GetAllProductsDto> getAllProductsWithCategoryDisabled();

    @Query(value = "select p from products p inner join categories c on p.category_id = c.category_id where c.is_active = false" , nativeQuery = true)
    List<Product> getAllProductsWithCategoryDisabled2();

    @Query("select p from Product p join p.supplier s where s.supplierId = :supplierId ")
    List<Product> findBySupplierId(int supplierId);

    @Query(value = "select p from products p where p.supplier_id = :supplierId", nativeQuery = true)
    List<Product> findBySupplierId2(int supplierId);

    //Product getByProductName(String productName); // getBy = SQL de WHERE demektir.

    //List<Product> getByProductNameAndCategoryId(String productName, int categoryId); // And = Ve

    //List<Product> getByProductNameOrCategoryId(String productName, int categoryId); // Or = Veya

    //List<Product> getByCategoryIdIn(List<Integer> categories); // In = category id içerisindeki id'lerin listesi

    //List<Product> getByProductNameContains(String productName); // Contains = içeriyorsa demektir.

    //List<Product> getByProductNameStartsWith(String productName); // StartsWith = bu isimle başlayanları getir demektir.

   /* @Query("From Product where productName=:productName and categoryId=:categoryId")
    List<Product> getByNameAndCategory(String productName, int categoryId);*/
}
