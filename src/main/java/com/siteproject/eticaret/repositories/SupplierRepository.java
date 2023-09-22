package com.siteproject.eticaret.repositories;

import com.siteproject.eticaret.entities.Product;
import com.siteproject.eticaret.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {



    Boolean existsByUserEmail(String userEmail);

}
