package com.E_commerce.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.E_commerce.model.Category;
import com.E_commerce.service.AdminService;
import com.E_commerce.service.ShopOwnerService;
import com.E_commerce.service.userService;
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private userService uService;

    @Autowired
    private ShopOwnerService shService;

    @GetMapping("/users")
    public String viewUsers(Model model) {
        model.addAttribute("users", uService.getAllUsers());
        return "adminViewUsers";
    }

    @GetMapping("/shopowners")
    public String viewShopOwners(Model model) {
        model.addAttribute("shopowners", shService.getAllShopOwners());
        return "adminViewShopOwners";
    }

    @PostMapping("/approveUser/{id}")
    public String approveUser(@PathVariable("id") int id) {
        uService.approveUser(id);
        return "redirect:/admin/users";
    }

    @PostMapping("/rejectUser/{id}")
    public String rejectUser(@PathVariable("id") int id) {
        uService.rejectUser(id);
        return "redirect:/admin/users";
    }

    @PostMapping("/approveShopOwner/{id}")
    public String approveShopOwner(@PathVariable("id") int id) {
        shService.approveShopOwner(id);
        return "redirect:/admin/shopowners";
    }

    @PostMapping("/rejectShopOwner/{id}")
    public String rejectShopOwner(@PathVariable("id") int id) {
        shService.rejectShopOwner(id);
        return "redirect:/admin/shopowners";
    }
    @Autowired
    private AdminService adminService;

//    @GetMapping("/categories")
//    public String viewCategories(Model model) {
//        model.addAttribute("categories", adminService.getAllCategories());
//        return "adminViewCategories";
//    }
//
//    @GetMapping("/category")
//    public String showAddCategoryForm(Model model) {
//        model.addAttribute("category", new Category());
//        return "addCategory";
//    }
//
//    @PostMapping("/admin/addCategory")
//    public String addCategory(Category category) {
//        adminService.addCategory(category);
//        return "adminViewCategory";
//    }
//
//    @GetMapping("/editCategory/{id}")
//    public String showEditCategoryForm(@PathVariable("id") int id, Model model) {
//        model.addAttribute("category", adminService.getCategoryById(id).orElse(null));
//        return "adminEditCategory";
//    }
//
//    @PostMapping("/updateCategory")
//    public String updateCategory(Category category) {
//        adminService.updateCategory(category);
//        return "redirect:/admin/categories";
//    }
//
//    @PostMapping("/deleteCategory/{id}")
//    public String deleteCategory(@PathVariable("id") int id) {
//        adminService.deleteCategoryById(id);
//        return "redirect:/admin/categories";
//    }
//}

    @GetMapping("/categories")
    public String viewCategories(Model model) {
        model.addAttribute("categories", adminService.getAllCategories());
        return "adminViewCategory";
    }

    @GetMapping("/category")
    public String showAddCategoryForm(Model model) {
        model.addAttribute("category", new Category());
        return "addCategory";
    }

    @PostMapping("/addCategory")
    public String addCategory(Category category) {
        adminService.addCategory(category);
        return "redirect:/admin/categories";
    }

    @GetMapping("/editCategory/{id}")
    public String showEditCategoryForm(@PathVariable("id") int id, Model model) {
        model.addAttribute("category", adminService.getCategoryById(id).orElse(null));
        return "adminEditCategory";
    }

    @PostMapping("/updateCategory")
    public String updateCategory(Category category) {
        adminService.updateCategory(category);
        return "redirect:/admin/categories";
    }

    @PostMapping("/deleteCategory/{id}")
    public String deleteCategory(@PathVariable("id") int id) {
        adminService.deleteCategoryById(id);
        return "redirect:/admin/categories";
    }
}




