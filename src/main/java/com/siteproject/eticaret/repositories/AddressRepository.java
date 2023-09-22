package com.siteproject.eticaret.repositories;

import com.siteproject.eticaret.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AddressRepository extends JpaRepository<Address, Integer> {
  /*  @Query("select a from Address a join a.user u where u.user_id = :userId")
    Address findByUserId(int userId);*/
}
