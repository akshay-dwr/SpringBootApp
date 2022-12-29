package com.programming.spring.SpringMVCUsingSpringBoot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.programming.spring.SpringMVCUsingSpringBoot.beans.Login;
import com.programming.spring.SpringMVCUsingSpringBoot.beans.User;
import com.programming.spring.SpringMVCUsingSpringBoot.exceptions.ApplicationException;
import com.programming.spring.SpringMVCUsingSpringBoot.repository.UserRepository;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public String login(@ModelAttribute("login") Login login) throws ApplicationException {
        System.out.println("User - " + login.getUsername());

        User user = userRepository.searchByName(login.getUsername());
        if(user == null){
            throw new ApplicationException("User Not Found. Not Authorized!");
        }
        return "search";
    }
}

