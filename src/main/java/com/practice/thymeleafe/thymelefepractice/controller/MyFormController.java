package com.practice.thymeleafe.thymelefepractice.controller;

import javax.validation.Valid;

import com.practice.thymeleafe.thymelefepractice.model.UserDetails;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MyFormController {

    @GetMapping("/form")
    public String myForm(final Model m) {
        System.out.println("Inside login form handler..");
        m.addAttribute("loginData", new UserDetails());
        return "form/login";
    }

    // process form here
    @PostMapping("/process")
    public String validateForm(@Valid @ModelAttribute("loginData") final UserDetails loginData, BindingResult result,
            Model model) {

        if (result.hasErrors()) {
            for (ObjectError element : result.getAllErrors()) {
                System.out.println(element.getObjectName() + " " + element.getDefaultMessage());
            }
            return "form/login";
        }

        System.out.println(loginData.toString());
        return "form/success";
    }

}