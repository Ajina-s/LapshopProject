package com.E_commerce.service;
//
import com.E_commerce.model.Products;
import com.E_commerce.model.Category;
import com.E_commerce.Repository.CategoryRepository;
import com.E_commerce.Repository.productRepository;
import com.E_commerce.Repository.shopLoginRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class productService {

    @Autowired
    private productRepository productRepository;

    public void saveProduct(Products product) {
        productRepository.save(product);
    }
    public Optional<Products> getProductById(Integer id) {
        return productRepository.findById(id);
    }
    public List<Products> getProductsByLoginid(int loginid) {
        return productRepository.findByLoginid(loginid);
    }
    public List<Products> searchProducts(String query) {
        Set<Products> products = new HashSet<>();

        products.addAll(productRepository.findByNameContainingIgnoreCase(query));
        products.addAll(productRepository.findByProcessorContainingIgnoreCase(query));
        products.addAll(productRepository.findByStorageContainingIgnoreCase(query));
        products.addAll(productRepository.findByCategoryNameContainingIgnoreCase(query));

        return List.copyOf(products);
    }
}

////
////import java.util.List;
////
////@Service
////public class productService {
////
////    @Autowired
////    private productRepository productRepository;
////
////    @Autowired
////    private CategoryRepository categoryRepository;
////
////    @Autowired
////    private shopLoginRepository loginRepository;
////
////    public List<Category> getAllCategories() {
////        return categoryRepository.findAll();
////    }
////
////    public void addProduct(Products product) {
////        // Get the currently logged-in user
////        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
////        String loginid;
////        String role;
////
////        if (principal instanceof UserDetails) {
////            UserDetails userDetails = (UserDetails) principal;
////            loginid = userDetails.getUsername();
////            var login = loginRepository.findByEmail(loginid); // Adjust based on your login repository
////            role = (login != null) ? login.getRole() : "User"; // Default role if not found
////        } else {
////            loginid = principal.toString();
////            role = "User"; // Default role or handle appropriately
////        }
////
////        product.setLoginid(loginid);
////        product.setRole(role);
////
////        productRepository.save(product);
////    }
////}
//package com.E_commerce.service;
//
//import com.E_commerce.model.Products;
//import com.E_commerce.model.Category;
//import com.E_commerce.model.shopLog;
//import com.E_commerce.Repository.CategoryRepository;
//import com.E_commerce.Repository.productRepository;
//import com.E_commerce.Repository.shopLoginRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class productService {
//
//    @Autowired
//    private productRepository productRepository;
//
//    @Autowired
//    private CategoryRepository categoryRepository;
//
//    @Autowired
//    private shopLoginRepository loginRepository;
//
//    public List<Category> getAllCategories() {
//        return categoryRepository.findAll();
//    }
//
//    public void addProduct(Products product) {
//        // Get the currently logged-in user
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        String loginid;
//        String role;
//
//        if (principal instanceof UserDetails) {
//            UserDetails userDetails = (UserDetails) principal;
//            loginid = userDetails.getUsername();
//
//            // Find the shopLog entry by email
//            Optional<shopLog> loginOptional = loginRepository.findByEmail(loginid);
//
//            // Get the role from the shopLog entry if present, otherwise default to "User"
//            role = loginOptional.map(shopLog::getRole).orElse("shop_owner");
//        } else {
//            loginid = principal.toString();
//            role = "shop_owner"; // Default role or handle appropriately
//        }
//
//        product.setLoginid(loginid);
//        product.setRole(role);
//
//        productRepository.save(product);
//        
//    }
//}
