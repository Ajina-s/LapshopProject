package com.E_commerce.controller;
//
//import com.E_commerce.model.Products;
//import com.E_commerce.model.User;
//import com.E_commerce.model.shop_owner;
//import com.E_commerce.Repository.UserRepository;
//import com.E_commerce.Repository.shopOwnerRepository;
//import com.E_commerce.model.Category;
//import com.E_commerce.service.AdminService;
//import com.E_commerce.service.productService;
//
//import jakarta.servlet.http.HttpSession;
//
//import java.io.IOException;
//import java.security.Principal;
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;
//
//
//@Controller
//public class productController {
//
//    @Autowired
//    private AdminService categoryService;
//
//    @Autowired
//    private productService productService;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private shopOwnerRepository shopOwnerRepository;
////    @GetMapping("/addProduct")
////    public String showAddProductForm(Model model, Principal principal) {
////        if (principal == null) {
////            return "redirect:/login"; // Redirect to login if the principal is null
////        }
////
////        List<Category> categories = categoryService.getAllCategories();
////        model.addAttribute("categories", categories);
////        model.addAttribute("product", new Products());
////        model.addAttribute("username", principal.getName());
////        return "addProduct";
////    }
////    
////
////    @PostMapping("/addProduct")
////    public String addProduct(@ModelAttribute Products product, @RequestParam("imageFile") MultipartFile imageFile, Principal principal) throws IOException {
////        if (principal == null) {
////            return "redirect:/login"; // Redirect to login if the principal is null
////        }
////
////        String email = principal.getName();
////
////        // Find user or shop owner by email
////        Optional<User> user = userRepository.findByEmail(email);
////        Optional<shop_owner> shopOwner = shopOwnerRepository.findByEmail(email);
////
////        if (user.isPresent()) {
////            product.setLogin(user.get().getLogin());
////            product.setRole("User");
////        } else if (shopOwner.isPresent()) {
////            product.setLogin(shopOwner.get().getLogin());
////            product.setRole("shop_owner");
////        } else {
////            // Handle the case where the user or shop owner is not found
////            return "redirect:/error"; // or any error handling page
////        }
////
////        // Handle image file
////        if (!imageFile.isEmpty()) {
////            product.setImage(imageFile.getBytes());
////        }
////
////        productService.saveProduct(product);
////        return "redirect:/success"; // Redirect to a success page or a product list page
////    }
//
////    @GetMapping("/addProduct")
////    public String showAddProductForm(Model model, HttpSession session) {
////        String email = (String) session.getAttribute("email");
////
////        if (email == null) {
////            return "redirect:/login"; // Redirect to login if no email is found in session
////        }
////
////        List<Category> categories = categoryService.getAllCategories();
////        model.addAttribute("categories", categories);
////        model.addAttribute("product", new Products());
////        model.addAttribute("username", email);
////        return "addProduct";
////    }
////    
////    @PostMapping("/addProduct")
////    public String addProduct(@ModelAttribute Products product, @RequestParam("imageFile") MultipartFile imageFile, HttpSession session) throws IOException {
////        String email = (String) session.getAttribute("email");
////
////        if (email == null) {
////            return "redirect:/login"; // Redirect to login if no email is found in session
////        }
////
////        // Find user or shop owner by email
////        Optional<User> user = userRepository.findByEmail(email);
////        Optional<shop_owner> shopOwner = shopOwnerRepository.findByEmail(email);
////
////        if (user.isPresent()) {
////            product.setLogin(user.get().getLogin());
////            product.setRole("User");
////        } else if (shopOwner.isPresent()) {
////            product.setLogin(shopOwner.get().getLogin());
////            product.setRole("shop_owner");
////        } else {
////            // Handle the case where the user or shop owner is not found
////            return "redirect:/error"; // or any error handling page
////        }
////
////        // Handle image file
////        if (!imageFile.isEmpty()) {
////            product.setImage(imageFile.getBytes());
////        }
////
////        productService.saveProduct(product);
////        return "addProduct"; // Redirect to a success page or a product list page
////    }
//    @GetMapping("/addProduct")
//    public String showAddProductForm(Model model, HttpSession session) {
//        String email = (String) session.getAttribute("email");
//
//        if (email == null) {
//            return "redirect:/login"; // Redirect to login if no email is found in session
//        }
//
//        List<Category> categories = categoryService.getAllCategories();
//        model.addAttribute("categories", categories);
//        model.addAttribute("product", new Products());
//        model.addAttribute("username", email);
//        return "addProduct";
//    }
//
//    @PostMapping("/addProduct")
//    public String addProduct(@ModelAttribute Products product, @RequestParam("imageFile") MultipartFile imageFile, HttpSession session) throws IOException {
//        String email = (String) session.getAttribute("email");
//
//        if (email == null) {
//            return "redirect:/login"; // Redirect to login if no email is found in session
//        }
//
//        // Find user or shop owner by email
//        Optional<User> user = userRepository.findByEmail(email);
//        Optional<shop_owner> shopOwner = shopOwnerRepository.findByEmail(email);
//
//        if (user.isPresent()) {
//            product.setLogin(user.get().getLogin());
//            product.setRole("User");
//        } else if (shopOwner.isPresent()) {
//            product.setLogin(shopOwner.get().getLogin());
//            product.setRole("shop_owner");
//        } else {
//            // Handle the case where the user or shop owner is not found
//            return "redirect:/error"; // or any error handling page
//        }
//
//        // Handle image file
//        if (!imageFile.isEmpty()) {
//            product.setImage(imageFile.getBytes());
//        }
//
//        productService.saveProduct(product);
//        return "viewProducts"; // Redirect to a success page or a product list page
//    }
//}
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import com.E_commerce.service.productService;

import jakarta.servlet.http.HttpSession;

import com.E_commerce.model.Category;
import com.E_commerce.model.Products;
import com.E_commerce.model.User;
import com.E_commerce.model.shop_owner;
import com.E_commerce.service.AdminService;
import com.E_commerce.Repository.shopOwnerRepository;
import com.E_commerce.Repository.UserRepository;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
public class productController {

    @Autowired
    private AdminService categoryService;

    @Autowired
    private productService productService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private shopOwnerRepository shopOwnerRepository;

    @GetMapping("/addProduct")
    public String showAddProductForm(Model model, HttpSession session) {
        String email = (String) session.getAttribute("email");

        if (email == null) {
            return "redirect:/login"; // Redirect to login if no email is found in session
        }

        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        model.addAttribute("product", new Products());
        model.addAttribute("username", email);
        return "addProduct";
    }

    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute Products product,
                             @RequestParam("imageFile") MultipartFile imageFile,
                             @RequestParam(value = "moreQuantity", required = false) String moreQuantity,
                             HttpSession session) throws IOException {
        String email = (String) session.getAttribute("email");

        if (email == null) {
            return "redirect:/login"; // Redirect to login if no email is found in session
        }

        // Find user or shop owner by email
        Optional<User> user = userRepository.findByEmail(email);
        Optional<shop_owner> shopOwner = shopOwnerRepository.findByEmail(email);

        if (user.isPresent()) {
            product.setLoginid(user.get().getLoginid()); // Directly get loginid from User
            product.setRole("User");
        } else if (shopOwner.isPresent()) {
            product.setLoginid(shopOwner.get().getLoginid()); // Directly get loginid from shop_owner
            product.setRole("shop_owner");
        } else {
            // Handle the case where the user or shop owner is not found
            return "redirect:/error"; // or any error handling page
        }

        // Handle image file
        if (!imageFile.isEmpty()) {
            product.setImage(imageFile.getBytes());
        }
        if ("more".equals(product.getQuantity())) {
            if (moreQuantity != null && !moreQuantity.isEmpty()) {
                try {
                    product.setQuantity(Integer.parseInt(moreQuantity));
                } catch (NumberFormatException e) {
                    // Handle parsing error
                    return "redirect:/error"; // or any error handling page
                }
            }
        } else {
            // Assuming the quantity is a valid number from the form
            try {
                product.setQuantity(Integer.parseInt(product.getQuantity().toString()));
            } catch (NumberFormatException e) {
                // Handle parsing error
                return "redirect:/error"; // or any error handling page
            }
        }

      

        productService.saveProduct(product);
        return "viewProducts"; // Redirect to a success page or a product list page
    }
    @GetMapping("/viewProducts")
    public String viewProductsByUserOrShopOwner(Model model, HttpSession session) {
        String email = (String) session.getAttribute("email");

        if (email == null) {
            return "redirect:/login"; // Redirect to login if no email is found in session
        }

        Optional<User> user = userRepository.findByEmail(email);
        Optional<shop_owner> shopOwner = shopOwnerRepository.findByEmail(email);

        if (user.isPresent()) {
            List<Products> products = productService.getProductsByLoginid(user.get().getLoginid());
            model.addAttribute("products", products);
            model.addAttribute("username", email);
        } else if (shopOwner.isPresent()) {
            List<Products> products = productService.getProductsByLoginid(shopOwner.get().getLoginid());
            model.addAttribute("products", products);
            model.addAttribute("username", email);
        } else {
            return "redirect:/error"; // or any error handling page
        }

        return "viewProducts";
    }
    @GetMapping("/view-product")
    public String viewProduct(@RequestParam("id") int id, Model model) {
        Optional<Products> productOptional = productService.getProductById(id);
        if (productOptional.isPresent()) {
            model.addAttribute("product", productOptional.get());
            return "productView";
        } else {
            return "error"; // Return an error view if product is not found
        }
    }
}

