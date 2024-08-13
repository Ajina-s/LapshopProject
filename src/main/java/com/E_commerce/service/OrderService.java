package com.E_commerce.service;

import java.util.List;

import com.E_commerce.model.orders;
import com.E_commerce.model.shop_owner;

public interface OrderService 
{
	List<orders> findByLoginId(Integer loginId);
    List<orders> findByShopOwner(shop_owner shopOwner);
    void saveOrder(orders order);
}

