package com.E_commerce.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.E_commerce.model.cart;

public interface CartRepository extends JpaRepository<cart, Integer> 
{
	List<cart> findByLoginId(Integer loginId);
} 

