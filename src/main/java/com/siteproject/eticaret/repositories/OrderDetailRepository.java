package com.siteproject.eticaret.repositories;

import com.siteproject.eticaret.entities.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
}
