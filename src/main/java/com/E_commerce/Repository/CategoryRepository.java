package com.E_commerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.E_commerce.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> { 

}
