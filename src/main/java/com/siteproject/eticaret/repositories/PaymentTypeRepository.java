package com.siteproject.eticaret.repositories;

import com.siteproject.eticaret.entities.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentTypeRepository extends JpaRepository<PaymentType, Integer> {
}
