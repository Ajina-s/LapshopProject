package com.E_commerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.E_commerce.Repository.CategoryRepository;
import com.E_commerce.Repository.shopLoginRepository;
import com.E_commerce.model.Category;
import com.E_commerce.model.shopLog;
import com.E_commerce.model.shop_owner;

@Service
public class AdminService {
    @Autowired
    private shopLoginRepository logRepo;

    public Optional<shopLog> findByEmailAndPassword(String email) {
        return logRepo.findByEmail(email);
    }
    @Autowired
    private CategoryRepository categoryRepository;
    
    // Add a new category
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }
    
    // Get all categories
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
    
    // Get a category by id
    public Optional<Category> getCategoryById(int id) {
        return categoryRepository.findById(id);
    }
    
    // Update a category
    public Category updateCategory(Category category) {
        return categoryRepository.save(category);
    }
    
    // Delete a category by id
    public void deleteCategoryById(int id) {
        categoryRepository.deleteById(id);
    }
}
     
   

