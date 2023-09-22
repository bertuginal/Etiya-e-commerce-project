package com.siteproject.eticaret.repositories;

import com.siteproject.eticaret.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Boolean existsByCategoryName(String categoryName);
}
