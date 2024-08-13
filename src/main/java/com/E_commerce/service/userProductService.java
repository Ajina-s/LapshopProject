package com.E_commerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.E_commerce.Repository.productRepository;
import com.E_commerce.model.Products;

import java.util.List;
import java.util.Optional;

@Service
public class userProductService {
	

	    @Autowired
	    private productRepository productRepository;

	    public List<Products> getAllProducts() {
	        List<Products> products = productRepository.findAll();
	        System.out.println("Fetched Products: " + products); // Debugging statement
	        return products;
	    }

	    public List<Products> searchProducts(String searchQuery) {
	        return productRepository.findByNameContainingIgnoreCase(searchQuery);
	    }

	    public Optional<Products> getProductById(int productId) {
	        return productRepository.findById(productId);
	    }
	}


//
//    @Autowired
//    private productRepository productRepository;
//
//    public List<Products> getAllProducts() {
//        return productRepository.findAll();
//    }
//
//    public List<Products> searchProducts(String searchQuery) {
//        return productRepository.findByNameContainingIgnoreCase(searchQuery);
//    }
//
//    public Optional<Products> getProductById(int productId) {
//        return productRepository.findById(productId);
//    }
//}
