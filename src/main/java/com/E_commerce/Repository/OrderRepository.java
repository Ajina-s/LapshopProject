package com.E_commerce.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.E_commerce.model.orders;
import com.E_commerce.model.shop_owner;

public interface OrderRepository extends JpaRepository<orders, Long> {
    List<orders> findByLoginId(Integer loginId);
    List<orders> findByShopOwner(shop_owner shopOwner);
}