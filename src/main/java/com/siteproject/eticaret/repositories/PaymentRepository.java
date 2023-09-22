package com.siteproject.eticaret.repositories;

import com.siteproject.eticaret.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
