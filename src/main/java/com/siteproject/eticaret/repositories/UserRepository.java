package com.siteproject.eticaret.repositories;

import com.siteproject.eticaret.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
