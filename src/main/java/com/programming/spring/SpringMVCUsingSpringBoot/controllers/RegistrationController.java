package com.programming.spring.SpringMVCUsingSpringBoot.controllers;

import com.programming.spring.SpringMVCUsingSpringBoot.beans.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    @Autowired
    private CrudRepository<User, Integer> userRepository;

    @PostMapping("/registeruser")
    public String registerUser(@ModelAttribute("newuser") User user, Model model){
        System.out.println("user registered");
        userRepository.save(user);
        model.addAttribute("data saved","user registered successfully");
        return "login";

    }
}

