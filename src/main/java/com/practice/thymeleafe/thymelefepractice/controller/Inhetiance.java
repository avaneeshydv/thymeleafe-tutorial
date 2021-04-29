package com.practice.thymeleafe.thymelefepractice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Inhetiance {

    @GetMapping("/inherit")
    public String getInheritance(Model m){
        return "inheritance/about";
    }

    @GetMapping("/contact")
    public String getContact(Model m){
        return "inheritance/contact";
    }
    
}