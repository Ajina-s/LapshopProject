//
//
//package com.E_commerce.service;
//
//import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import com.E_commerce.Repository.shopLoginRepository;
//import com.E_commerce.model.shopLog;
//import java.util.Optional;
//
//@Service
//public class shopLoginService {
//
//    @Autowired
//    private shopLoginRepository rep;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    public shopLog login(String email, String password) {
//        Optional<shopLog> logUserOpt = rep.findByEmail(email);
//        if (logUserOpt.isPresent()) {
//            shopLog logUser = logUserOpt.get();
//            if (passwordEncoder.matches(password, logUser.getPassword())) {
//                return logUser;
//            }
//        }
//        return null;
//    
//    }
//    public boolean passwordMatches(String rawPassword, String encodedPassword) {
//        return passwordEncoder.matches(rawPassword, encodedPassword);
//    }
//
//    public void saveLogin(shopLog log) {
//        rep.save(log);
//    }
//
//    public int getCurrentUserId(Authentication authentication) {
//        shopLog logUser = rep.findByEmail(authentication.name()).orElse(null);
//        return logUser != null ? logUser.getId() : -1;
//    }
//
//    public String getCurrentUserRole(Authentication authentication) {
//        shopLog logUser = rep.findByEmail(authentication.name()).orElse(null);
//        return logUser != null ? logUser.getRole() : null;
//    }
//}
//
package com.E_commerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.E_commerce.Repository.UserRepository;
import com.E_commerce.Repository.shopLoginRepository;
import com.E_commerce.Repository.shopOwnerRepository;
import com.E_commerce.model.User;
import com.E_commerce.model.shopLog;
import com.E_commerce.model.shop_owner;

@Service
public class shopLoginService {

    @Autowired
    private shopLoginRepository shopLoginRepository;

    @Autowired
    private shopOwnerRepository shopOwnerRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public shopLog login(String email, String password) {
        Optional<shopLog> logUserOpt = shopLoginRepository.findByEmail(email);
        if (logUserOpt.isPresent()) {
            shopLog logUser = logUserOpt.get();
            if (passwordEncoder.matches(password, logUser.getPassword())) {
                return logUser;
            }
        }
        return null;
    }

    public boolean passwordMatches(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    public void saveLogin(shopLog log) {
        shopLoginRepository.save(log);
    }

    public int getCurrentUserId(Authentication authentication) {
        if (authentication == null) {
            return -1; // or throw an exception
        }
        shopLog logUser = shopLoginRepository.findByEmail(authentication.getName()).orElse(null);
        if (logUser != null) {
            if ("shop_owner".equals(logUser.getRole())) {
                shop_owner owner = shopOwnerRepository.findByEmail(logUser.getEmail()).orElse(null);
                return owner != null ? owner.getId() : -1;
            } else if ("User".equals(logUser.getRole())) {
                User user = userRepository.findByEmail(logUser.getEmail()).orElse(null);
                return user != null ? user.getId() : -1;
            }
        }
        return -1;
    }

    public String getCurrentUserRole(Authentication authentication) {
        if (authentication == null) {
            return null; // or throw an exception
        }
        shopLog logUser = shopLoginRepository.findByEmail(authentication.getName()).orElse(null);
        return logUser != null ? logUser.getRole() : null;
    }
    public shop_owner getShopOwnerById(int id) {
        return shopOwnerRepository.findById(id).orElse(null);
    }
}
