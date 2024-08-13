//package com.E_commerce.config;
//import org.springframework.security.core.userdetails.User;
//
//import java.util.Collections;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//
//
//@Configuration
//public class SecurityConfig  {
//	
//@Bean
//public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//    http
//        .authorizeHttpRequests(authorizeRequests ->
//            authorizeRequests
//                .requestMatchers( "/","/register","/login").permitAll()
//                .anyRequest().authenticated()
//        )
//        .formLogin(formLogin ->
//            formLogin
//                .loginPage("/login")
//                .permitAll()
//        )
//        .logout(logout -> logout.permitAll());
//
//    return http.build();
//}
//@Bean
//public UserDetailsService userDetailsService() {
//    // Manually creating UserDetails
//    UserDetails user = new User(
//        "user", // username
//        passwordEncoder().encode("password"), // encoded password
//        Collections.singleton(() -> "ROLE_USER") // authorities (roles)
//    );
//
//    return new InMemoryUserDetailsManager(user);
//}
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}


package com.E_commerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
