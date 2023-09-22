package com.siteproject.eticaret.repositories;

import com.siteproject.eticaret.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
