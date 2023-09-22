package com.siteproject.eticaret.repositories;

import com.siteproject.eticaret.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
}
