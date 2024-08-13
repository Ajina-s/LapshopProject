package com.E_commerce.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.E_commerce.Repository.shopLoginRepository;
import com.E_commerce.model.shopLog;

@Configuration

//    @Bean
//    public CommandLineRunner dataLoader() {
//        return args -> {
//            // Check if admin user already exists
//            if (loginRepository.findByEmail("admin@gmail.com") == null) {
//                // Create and save the admin user
//                shopLog adminUser = new shopLog();
//                adminUser.setEmail("admin@gmail.com");
//                adminUser.setPassword(passwordEncoder.encode("admin1")); // Encode password
//                adminUser.setRole("Admin");
//               // adminUser.setLoginid("101");
//
//                loginRepository.save(adminUser);
//            }
//        };
//    }
//}
    @Component
    public class DataInitializer implements CommandLineRunner {

        @Autowired
        private shopLoginRepository userRepository; 

        @Autowired
        private PasswordEncoder passwordEncoder; 

        @Override
        public void run(String... args) throws Exception {
            if (userRepository.findByEmail("admin@gmail.com") == null) {
                String encodedPassword = passwordEncoder.encode("admin"); 
                shopLog admin = new shopLog();
                admin.setEmail("admin@gmail.com");
                admin.setPassword(encodedPassword);
                admin.setRole("Admin");
                userRepository.save(admin);
            }
        }
    }
