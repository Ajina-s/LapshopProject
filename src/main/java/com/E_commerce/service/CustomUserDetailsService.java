//package com.E_commerce.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import com.E_commerce.Repository.UserRepository;
//import com.E_commerce.Repository.shopLoginRepository;
//import com.E_commerce.model.User;
//import com.E_commerce.model.shopLog;
//
//public class CustomUserDetailsService  implements UserDetailsService {
//
//    @Autowired
//    private shopLoginRepository logRepo;
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        shopLog logUser = logRepo.findByEmail(email);
//        if (logUser == null) {
//            throw new UsernameNotFoundException("User not found");
//        }
//
//        return new User(
//                logUser.getEmail(),
//                logUser.getPassword(),
//                Collections.singleton(() -> "ROLE_" + logUser.getRole().toUpperCase())
//        );
//    }
//}
