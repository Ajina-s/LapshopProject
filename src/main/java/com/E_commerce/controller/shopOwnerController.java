////
////package com.E_commerce.controller;
////
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.security.crypto.password.PasswordEncoder;
////import org.springframework.stereotype.Controller;
////import org.springframework.ui.Model;
////import org.springframework.web.bind.annotation.GetMapping;
////import org.springframework.web.bind.annotation.ModelAttribute;
////import org.springframework.web.bind.annotation.PostMapping;
////import org.springframework.web.bind.annotation.RequestMapping;
////
////import com.E_commerce.model.User;
////import com.E_commerce.model.shopLog;
////import com.E_commerce.model.shop_owner;
////import com.E_commerce.service.ShopOwnerService;
////import com.E_commerce.service.shopLoginService;
////import com.E_commerce.service.userService;
////
////@Controller
////public class shopOwnerController {
////
////    @Autowired
////    private ShopOwnerService shService;
////
////    @Autowired
////    private shopLoginService logService;
////
////    @Autowired
////    private userService uService;
////
////    @Autowired
////    private PasswordEncoder passwordEncoder;
////
////    @RequestMapping("/")
////    public String index() {
////        return "index";
////    }
////
////    @GetMapping("/ownerregistration")
////    public String registration(Model m) {
////        m.addAttribute("shop", new shop_owner());
////        return "shopOwnerRegistration";
////    }
////
////    @PostMapping("/ownerregistration")
////    public String ownerRegistration(@ModelAttribute("shop") shop_owner sh) {
////        // Encode the password
////        String encodedPassword = passwordEncoder.encode(sh.getPassword());
////        sh.setPassword(encodedPassword);
////
////        shService.ownerRegistration(sh);
////
////        int logId = sh.getId();
////        String loginId = String.valueOf(logId);
////        shopLog login = new shopLog();
////        login.setEmail(sh.getEmail());
////        login.setPassword(encodedPassword);
////        login.setRole("shop_owner");
////        login.setLoginid(loginId);
////        logService.saveLogin(login);
////
////        return "redirect:/";
////    }
////
////    @RequestMapping("/userregistration")
////    public String userRegistration(Model m) {
////        m.addAttribute("user", new User());
////        return "userRegistration";
////    }
////
////    @PostMapping("/userregistration")
////    public String userRegistration(@ModelAttribute("user") User u) {
////        // Encode the password
////        String encodedPassword = passwordEncoder.encode(u.getPassword());
////        u.setPassword(encodedPassword);
////
////        uService.userRegistration(u);
////
////        int logId = u.getId();
////        String loginId = String.valueOf(logId);
////        shopLog login = new shopLog();
////        login.setEmail(u.getEmail());
////        login.setPassword(encodedPassword);
////        login.setRole("User");
////        login.setLoginid(loginId);
////        logService.saveLogin(login);
////
////        return "redirect:/";
////    }
////
////    @GetMapping("/login")
////    public String loginPage(Model model) {
////        model.addAttribute("login", new shopLog());
////        return "login";
////    }
////}
////
package com.E_commerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.E_commerce.model.User;
import com.E_commerce.model.shopLog;
import com.E_commerce.model.shop_owner;
import com.E_commerce.service.ShopOwnerService;
import com.E_commerce.service.shopLoginService;
import com.E_commerce.service.userService;

@Controller
public class shopOwnerController {

    @Autowired
    private ShopOwnerService shService;

    @Autowired
    private shopLoginService logService;

    @Autowired
    private userService uService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/ownerregistration")
    public String registration(Model m) {
        m.addAttribute("shop", new shop_owner());
        return "shopOwnerRegistration";
    }

    @PostMapping("/ownerregistration")
    public String ownerRegistration(@ModelAttribute("shop") shop_owner sh) {
        // Encode the password
        String encodedPassword = passwordEncoder.encode(sh.getPassword());
        sh.setPassword(encodedPassword);

        shopLog login = new shopLog();
        login.setEmail(sh.getEmail());
        login.setPassword(encodedPassword);
        login.setRole("shop_owner");

        sh.setLogin(login);

        shService.ownerRegistration(sh);
        logService.saveLogin(login);

        return "redirect:/";
    }

    @RequestMapping("/userregistration")
    public String userRegistration(Model m) {
        m.addAttribute("user", new User());
        return "userRegistration";
    }

    @PostMapping("/userregistration")
    public String userRegistration(@ModelAttribute("user") User u) {
        // Encode the password
        String encodedPassword = passwordEncoder.encode(u.getPassword());
        u.setPassword(encodedPassword);

        shopLog login = new shopLog();
        login.setEmail(u.getEmail());
        login.setPassword(encodedPassword);
        login.setRole("User");

         u.setLogin(login);

        uService.userRegistration(u);
        logService.saveLogin(login);

        return "redirect:/";
    }

    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("login", new shopLog());
        return "login";
    }
}
