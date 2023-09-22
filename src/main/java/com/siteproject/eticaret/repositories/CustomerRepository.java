package com.siteproject.eticaret.repositories;

import com.siteproject.eticaret.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Boolean existsByUserEmail(String userEmail);

}
