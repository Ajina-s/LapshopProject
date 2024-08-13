package com.E_commerce.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.E_commerce.Repository.OrderRepository;
import com.E_commerce.model.Products;
import com.E_commerce.model.orders;
import com.E_commerce.model.shop_owner;
@Service
public class orderserviceimp implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<orders> findByLoginId(Integer loginId) {
        return orderRepository.findByLoginId(loginId);
    }

    @Override
    public List<orders> findByShopOwner(shop_owner shopOwner) {
        return orderRepository.findByShopOwner(shopOwner);
    }

//    @Override
//    public void saveOrder(orders order) {
//        orderRepository.save(order);
//    }
    @Override
    public void saveOrder(orders order) {
        // Validate order fields
        if (order.getProduct() == null || 
            order.getQuantity() == null || 
            order.getAmount() == null || 
            order.getDate() == null || 
            order.getStatus() == null || 
            order.getLoginId() == null || 
            order.getShopOwner() == null) {
            throw new IllegalArgumentException("All fields must be set before saving an order.");
        }

        try {
            orderRepository.save(order);
            System.out.println("Order saved successfully: " + order);
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception to debug
        }
    }

}



