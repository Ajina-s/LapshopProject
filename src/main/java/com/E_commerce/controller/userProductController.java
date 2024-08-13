package com.E_commerce.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.E_commerce.model.Products;
import com.E_commerce.model.User;
import com.E_commerce.model.cart;
import com.E_commerce.model.orders;
import com.E_commerce.model.shop_owner;
import com.E_commerce.service.CartService;
import com.E_commerce.service.OrderService;
import com.E_commerce.service.ShopOwnerService;
import com.E_commerce.service.userProductService;
import com.E_commerce.service.userService;

import jakarta.servlet.http.HttpSession;

@Controller
public class userProductController {

    @Autowired
    private userProductService productService;
    @Autowired
    private CartService cartService;
     
    @Autowired 
     private userService  userService;
    @Autowired
    private ShopOwnerService shopOwnerService;
    @Autowired
    private OrderService orderservice;

    @GetMapping("/userHome")
    public String userHome(HttpSession session, Model model) {
        // Fetch the username from the session
        String email = (String) session.getAttribute("email");
        if (email == null) {
            return "redirect:/login"; // Redirect to login if no user is logged in
        }
        
        List<Products> products = productService.getAllProducts();
        System.out.println("Products in userHome: " + products); // Debugging statement
        model.addAttribute("products", products);
        model.addAttribute("username", email); // Add username to model
        return "userHome"; // Thymeleaf template name for user home
    }
    @GetMapping("/searchProducts")
    public String searchProducts(@RequestParam("query") String query, HttpSession session, Model model) {
        String email = (String) session.getAttribute("email");
        if (email == null) {
            return "redirect:/login"; 
        }

        // Search products based on the query
        List<Products> searchResults = productService.searchProducts(query);

        // Add search results to the model
        model.addAttribute("products", searchResults);
        model.addAttribute("username", email); // Add username to model
        model.addAttribute("searchQuery", query); // Add the search query to the model for display

        // Return the same user home page with search results displayed
        return "userHome";
    }



    @GetMapping("/userviewproduct")
    public String viewProduct(@RequestParam("id") int id, Model model) {
        Optional<Products> productOptional = productService.getProductById(id);
        if (productOptional.isPresent()) {
            model.addAttribute("product", productOptional.get());
            return "userviewproduct"; // Thymeleaf template name for product details
        } else {
            return "error"; // Return an error view if product is not found
        }
        
    }
    @GetMapping("/image/{id}")
    @ResponseBody
    public byte[] getImage(@PathVariable("id") int id) {
        Optional<Products> productOptional = productService.getProductById(id);
        if (productOptional.isPresent()) {
            Products product = productOptional.get();
            return product.getImage(); // Assuming image is stored as a byte array
        } else {
            return new byte[0]; // Return an empty byte array if product is not found
        }
    }
    

    @PostMapping("/addToCart")
    public String addToCart(@RequestParam("productId") int productId, HttpSession session, Model model) {
        String email = (String) session.getAttribute("email");
        if (email == null) {
            return "redirect:/login"; 
        }

        Optional<Products> productOptional = productService.getProductById(productId);
        if (productOptional.isPresent()) {
            Products product = productOptional.get();
            model.addAttribute("product", product);
            model.addAttribute("email", email);
            return "quantitySelection"; // Redirect to the quantity selection page
        } else {
            return "redirect:/userHome";
        }
    }
    @PostMapping("/saveCart")
    public String saveCart(@RequestParam("productId") int productId,
                           @RequestParam("quantity") String quantityStr,
                           @RequestParam(value = "customQuantity", required = false) Integer customQuantity,
                           HttpSession session) {
        String email = (String) session.getAttribute("email");
        if (email == null) {
            return "redirect:/login"; 
        }

        Optional<Products> productOptional = productService.getProductById(productId);
        if (productOptional.isPresent()) {
            Products product = productOptional.get();
            User user = userService.findByEmail(email);

            cart cart = new cart();
            cart.setProduct(product);
            cart.setImage(product.getImage());
            Double price = Double.parseDouble(product.getPrice());
            
            Integer quantity = "more".equals(quantityStr) ? customQuantity : Integer.parseInt(quantityStr);
            cart.setAmount(price * quantity); // Set amount based on quantity
            cart.setDate(new Date());
            cart.setPurchaseStatus("Pending");
            cart.setQuantity(quantity); // Set quantity
            cart.setLoginId(user.getLoginid());
            cartService.saveCart(cart);

            return "redirect:/cartList"; // Redirect to the cart list page
        } else {
            return "redirect:/userHome";
        }
    }
    @GetMapping("/cartList")
    public String cartList(HttpSession session, Model model) {
        String email = (String) session.getAttribute("email");
        if (email == null) {
            return "redirect:/login"; 
        }

        User user = userService.findByEmail(email);
        List<cart> cartItems = cartService.findByLoginId(user.getLoginid());
        model.addAttribute("cartItems", cartItems);
        return "cartList"; // Thymeleaf template name for cart list
    }

//    @GetMapping("/orderPage")
//    public String orderPage(@RequestParam("cartId") List<Integer> cartIds, HttpSession session, Model model) {
//        String email = (String) session.getAttribute("email");
//        if (email == null) {
//            return "redirect:/login"; 
//        }
//
//        User user = userService.findByEmail(email);
//        List<cart> cartItems = cartService.getCartsByIds(cartIds); // Fetch multiple cart items by their IDs
//
//        model.addAttribute("user", user);
//        model.addAttribute("cartItems", cartItems);
//        return "orderPage"; // Thymeleaf template name for the order page
//    }
//
//    @PostMapping("/placeOrder")
//    public String placeOrder(@RequestParam("cartIds") List<Integer> cartIds,
//                             HttpSession session) {
//        String email = (String) session.getAttribute("email");
//        if (email == null) {
//            return "redirect:/login"; 
//        }
//
//        List<cart> cartItems = cartService.getCartsByIds(cartIds);
//
//        for (cart item : cartItems) {
//            orders order = new orders();
//            order.setProduct(item.getProduct());
//            order.setQuantity(item.getQuantity());
//            order.setAmount(item.getAmount());
//            order.setDate(new Date());
//            order.setStatus("Pending");
//
//            // Set loginId from cart item
//            order.setLoginId(String.valueOf(item.getLoginId()));
//
//            // Fetch the shop owner who added the product
//            shop_owner shopOwner = shopOwnerService.findById(item.getProduct().getLoginid());
//            order.setShopOwner(shopOwner);
//            
//            cartService.deleteCart(item.getId());
//        }
//
//        return "redirect:/orderConfirmation"; // Redirect to an order confirmation page or another page as needed
//    }
//
//    @GetMapping("/shopOwnerOrders")
//    public String shopOwnerOrders(HttpSession session, Model model) {
//        String email = (String) session.getAttribute("email");
//        if (email == null) {
//            return "redirect:/login"; 
//        }
//
//        shop_owner shopOwner = shopOwnerService.findByEmail(email);
//        List<orders> orders = orderservice.findByShopOwner(shopOwner);
//
//        model.addAttribute("orders", orders);
//        return "shopOwnerOrders"; // Thymeleaf template name for shop owner orders
//    }

    @GetMapping("/orderPage")
    public String orderPage(@RequestParam("cartIds") List<Integer> cartIds, HttpSession session, Model model) {
        String email = (String) session.getAttribute("email");
        if (email == null) {
            return "redirect:/login"; 
        }

        // Fetch user and cart items
        User user = userService.findByEmail(email);
        List<cart> cartItems = cartService.getCartsByIds(cartIds);

        model.addAttribute("user", user);
        model.addAttribute("cartItems", cartItems);
        model.addAttribute("cartIds", cartIds); // Pass cartIds to the template
        return "orderPage";
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public String handleMissingParams(MissingServletRequestParameterException ex, Model model) {
        model.addAttribute("error", "Required parameter is missing: " + ex.getParameterName());
        return "error";
    }

//    @PostMapping("/placeOrder")
//    public String placeOrder(@RequestParam("cartIds") List<Integer> cartIds, HttpSession session) {
//        String email = (String) session.getAttribute("email");
//        if (email == null) {
//            return "redirect:/login"; 
//        }
//
//        List<cart> cartItems = cartService.getCartsByIds(cartIds);
//
//        for (cart item : cartItems) {
//            orders order = new orders();
//            order.setProduct(item.getProduct());
//            order.setQuantity(item.getQuantity());
//            order.setAmount(item.getAmount());
//            order.setDate(new Date());
//            order.setStatus("Pending");
//            order.setLoginId(String.valueOf(item.getLoginId()));
//
//         shop_owner shopOwner = shopOwnerService.findById(item.getProduct().getLoginid());
//            order.setShopOwner(shopOwner);
//
//            orderservice.saveOrder(order); // Save the order to the database
//            cartService.deleteCart(item.getId()); // Clear the cart after placing the order
//        }
//
//        return "orderConfirmation"; 
//    }
   
    @PostMapping("/placeOrder")
    public String placeOrder(@RequestParam("cartIds") String cartIdsParam, HttpSession session, RedirectAttributes redirectAttributes) {
        String email = (String) session.getAttribute("email");
        if (email == null) {
            return "redirect:/login";
        }

        // Convert comma-separated string to list of integers
        List<Integer> cartIds = Arrays.stream(cartIdsParam.split(","))
                                      .map(Integer::parseInt)
                                      .collect(Collectors.toList());

        List<cart> cartItems = cartService.getCartsByIds(cartIds);

        if (cartItems.isEmpty()) {
            redirectAttributes.addFlashAttribute("errorMessage", "No items found in the cart.");
            return "redirect:/orderPage";
        }

        for (cart item : cartItems) {
            orders order = new orders();
            order.setProduct(item.getProduct());
            order.setQuantity(item.getQuantity());
            order.setAmount(item.getAmount());
            order.setDate(new Date());
            order.setStatus("Pending");
            order.setLoginId(item.getProduct().getLoginid()); // Assuming this is Integer

            // Fetch shop_owner based on loginId from the product
            Integer productLoginId = item.getProduct().getLoginid();
            try {
                shop_owner shopOwner = shopOwnerService.findByLoginId(productLoginId);
                order.setShopOwner(shopOwner);
            } catch (RuntimeException e) {
                redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
                return "redirect:/orderPage";
            }

            try {
                orderservice.saveOrder(order);
                System.out.println("Order saved successfully: " + order);
            } catch (Exception e) {
                e.printStackTrace();
                redirectAttributes.addFlashAttribute("errorMessage", "Error saving order: " + e.getMessage());
                return "redirect:/orderPage";
            }

            cartService.deleteCart(item.getId());
        }

        redirectAttributes.addFlashAttribute("successMessage", "Order placed successfully!");
        return "orderConfirmation";
    }


//    @PostMapping("/placeOrder")
//    public String placeOrder(@RequestParam("cartIds") String cartIdsParam, HttpSession session, RedirectAttributes redirectAttributes) {
//        String email = (String) session.getAttribute("email");
//        if (email == null) {
//            return "redirect:/login";
//        }
//
//        List<Integer> cartIds = Arrays.stream(cartIdsParam.split(","))
//                                      .map(Integer::parseInt)
//                                      .collect(Collectors.toList());
//
//        // Assuming cartService is injected and has a method to fetch cart items by IDs
//        List<cart> cartItems = cartService.getCartsByIds(cartIds);
//
//        if (cartItems.isEmpty()) {
//            redirectAttributes.addFlashAttribute("errorMessage", "No items found in the cart.");
//            return "redirect:/orderPage";
//        }
//
//        for (cart item : cartItems) {
//            String loginId = item.getProduct().getLoginid().getLoginId(); // Make sure this is the correct field
//
//            try {
//                shop_owner shopOwner = shopOwnerService.findByLoginId(loginId);
//                // Process order and save it
//            } catch (RuntimeException e) {
//                redirectAttributes.addFlashAttribute("errorMessage", "Shop Owner not found for loginId: " + loginId);
//                return "redirect:/orderPage";
//            }
//
//            // Save order and delete cart item
//        }
//
//        redirectAttributes.addFlashAttribute("successMessage", "Order placed successfully!");
//        return "redirect:/orderConfirmation";
//    }
//

    @GetMapping("/shopOwnerOrders")
    public String shopOwnerOrders(HttpSession session, Model model) {
        String email = (String) session.getAttribute("email");
        if (email == null) {
            return "redirect:/login"; 
        }

        shop_owner shopOwner = shopOwnerService.findByEmail(email);
        List<orders> orders = orderservice.findByShopOwner(shopOwner);

        model.addAttribute("orders", orders);
        return "shopOwnerOrders";
    }

       @PostMapping("/buyNow")
    public String buyNow(@RequestParam("productId") int productId, HttpSession session) {
        // Implement logic to process the purchase
        return "redirect:/orderConfirmation"; // Redirect to an order confirmation page
    }
}
