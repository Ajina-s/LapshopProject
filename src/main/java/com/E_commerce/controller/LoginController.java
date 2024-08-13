////package com.E_commerce.controller;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.stereotype.Controller;
////import org.springframework.ui.Model;
////import org.springframework.web.bind.annotation.PostMapping;
////import org.springframework.web.bind.annotation.RequestParam;
////import com.E_commerce.model.User;
////import com.E_commerce.model.shop_owner;
////import com.E_commerce.model.shopLog;
////import com.E_commerce.service.userService;
////import com.E_commerce.service.ShopOwnerService;
////import com.E_commerce.service.shopLoginService;
////
////@Controller
////public class LoginController {
////
////    @Autowired
////    private userService uService;
////
////    @Autowired
////    private ShopOwnerService shService;
////
////    @Autowired
////    private shopLoginService logService;
////
////    @PostMapping("/login")
////    public String login(@RequestParam String email, @RequestParam String password, Model model) {
////        shopLog logUser = logService.login(email, password);
////
////        if (logUser != null) {
////            if ("User".equals(logUser.getRole())) {
////                User u = uService.findByEmailAndPassword(email, password);
////                if (u != null && u.isApproved()) {
////                    return "userHome";
////                }
////            } else if ("shop_owner".equals(logUser.getRole())) {
////                shop_owner shopOwner = shService.findByEmailAndPassword(email, password);
////                if (shopOwner != null && shopOwner.isApproved()) {
////                    return "shopOwnerHome";
////                }
////            } else if ("Admin".equals(logUser.getRole())) {
////                return "adminHome";
////            }
////        }
////        
////        model.addAttribute("error", "Invalid credentials or account not approved");
////        return "login";
////    }
////}
//package com.E_commerce.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.E_commerce.model.User;
//import com.E_commerce.model.shop_owner;
//import com.E_commerce.model.shopLog;
//import com.E_commerce.service.userService;
//
//import jakarta.servlet.http.HttpSession;
//
//import com.E_commerce.service.ShopOwnerService;
//import com.E_commerce.service.shopLoginService;
//
//@Controller
//public class LoginController {
//
//    @Autowired
//    private userService uService;
//
//    @Autowired
//    private ShopOwnerService shService;
//
//    @Autowired
//    private shopLoginService logService;
//
//    @PostMapping("/login")
//    public String login(@RequestParam String email, @RequestParam String password, HttpSession session, Model model) {
//        shopLog logUser = logService.login(email, password);
//
//        if (logUser != null) 
//        	 session.setAttribute("email", email);{
//            if ("User".equals(logUser.getRole())) {
//                User u = logUser.getUser();
//                if (u != null && u.isApproved()) {
//                    return "userHome";
//                }
//            } else if ("shop_owner".equals(logUser.getRole())) {
//                shop_owner shopOwner = logUser.getShopOwner();
//                if (shopOwner != null && shopOwner.isApproved()) {
//                    return "shopOwnerHome";
//                }
//            } else if ("ADMIN".equals(logUser.getRole())) {
//                return "adminHome";
//            }
//        }
//        
//        model.addAttribute("error", "Invalid credentials or account not approved");
//        return "login";
//    }
//}
package com.E_commerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.E_commerce.model.User;
import com.E_commerce.model.shop_owner;
import com.E_commerce.model.shopLog;
import com.E_commerce.service.userService;
import com.E_commerce.service.ShopOwnerService;
import com.E_commerce.service.shopLoginService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private userService uService;

    @Autowired
    private ShopOwnerService shService;

    @Autowired
    private shopLoginService logService;

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, HttpSession session, Model model) {
        shopLog logUser = logService.login(email, password);

        if (logUser != null) {
            // Set session attribute for email
            session.setAttribute("email", email);

            // Handle User role
            if ("User".equalsIgnoreCase(logUser.getRole())) {
                User user = uService.findByEmail(email);
                if (user != null && user.isApproved()) {
                    return "redirect:/userHome";
                }
            }

            // Handle Shop Owner role
            else if ("shop_owner".equalsIgnoreCase(logUser.getRole())) {
                shop_owner shopOwner = shService.findByEmail(email);
                if (shopOwner != null && shopOwner.isApproved()) {
                    return "redirect:/shopOwnerHome";
                }
            }

            // Handle Admin role
            else if ("Admin".equalsIgnoreCase(logUser.getRole())) {
                return "adminHome";
            }
        }

        // Handle invalid credentials or unapproved accounts
        model.addAttribute("error", "Invalid credentials or account not approved");
        return "login";
    }
}
