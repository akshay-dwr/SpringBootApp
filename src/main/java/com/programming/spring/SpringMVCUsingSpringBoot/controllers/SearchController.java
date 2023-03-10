package com.programming.spring.SpringMVCUsingSpringBoot.controllers;

import com.programming.spring.SpringMVCUsingSpringBoot.beans.Product;
import com.programming.spring.SpringMVCUsingSpringBoot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SearchController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/search")
    public String search(@RequestParam("search") String search, Model model){
        System.out.println("Search Controller Class");
        System.out.println("Search- " + search);

        List<Product> products = new ArrayList<>();
        products = productRepository.searchByName(search);
        model.addAttribute("products", products);
        return "search";
    }
}
