package com.E_commerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.E_commerce.Repository.CartRepository;
import com.E_commerce.model.cart;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepo;

    // Save a new cart entry
    public void saveCart(cart cart) {
        cartRepo.save(cart);
    }
    public List<cart> findByLoginId(Integer loginId) {
        return cartRepo.findByLoginId(loginId);
    }

    // Retrieve a cart entry by ID
    public Optional<cart> getCartById(int cartId) {
    	 return cartRepo.findById(cartId);
    }
    public List<cart> getCartsByIds(List<Integer> cartId) {
        return cartRepo.findAllById(cartId);
    }

    // Delete a cart entry
    public void deleteCart(int cartId) {
        cartRepo.deleteById(cartId);
    }
}