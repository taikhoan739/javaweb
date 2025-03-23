/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhm.controllers;

import com.nhm.services.CategoryService;
import com.nhm.services.ProductService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author admin
 */
@Controller
public class IndexController {
    @Autowired
    private CategoryService cateServices;
    @Autowired
    private ProductService prodServices;
    @RequestMapping("/")
    public String index(Model model,@RequestParam Map<String,String> params){
        model.addAttribute("categories", this.cateServices.getCates());
        model.addAttribute("products",this.prodServices.getProducts(params));
        return "index";
    }
}
