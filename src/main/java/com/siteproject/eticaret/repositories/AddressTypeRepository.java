package com.siteproject.eticaret.repositories;

import com.siteproject.eticaret.entities.Address;
import com.siteproject.eticaret.entities.AddressType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AddressTypeRepository extends JpaRepository<AddressType, Integer> {
}
