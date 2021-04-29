package com.practice.thymeleafe.thymelefepractice.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

    private static class Person {
        private String name;
        private int age;
        private LocalDate dateOfBirth;

        public Person(String name, int age, LocalDate dateOfBirth) {
            this.name = name;
            this.age = age;
            this.dateOfBirth = dateOfBirth;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public LocalDate getDateOfBirth() {
            return dateOfBirth;
        }

    }

    @GetMapping(value = "/variable")
    public String learanVariables(Model model) {

        model.addAttribute("name", "Avaneesh");
        model.addAttribute("age", 25);
        model.addAttribute("dateOfBirth", LocalDate.of(1997, 07, 05));
        model.addAttribute("weight", 75.0);

        return "variables";
    }

    @GetMapping(value = "/iterate")
    public String iterate(Model model) {

        List<Person> person = List.of(new Person("Avaneesh", 24, LocalDate.of(1997, 07, 05)),
                new Person("Atul", 26, LocalDate.of(1995, 06, 04)),
                new Person("Brijesh", 34, LocalDate.of(1989, 12, 15)),
                new Person("Rani", 24, LocalDate.of(1997, 06, 15)));

        Map<String, Integer> weight = Map.of("Avaneesh", 76, "Atul", 56, "Brijesh", 45, "Rani", 60);
        model.addAttribute("person", person);
        model.addAttribute("weight", weight);

        return "looping";
    }

    @GetMapping(value = "/checking")
    public String checkCondition(Model model) {
        System.out.println("Conditional Handler request...");
        model.addAttribute("isActive", true);
        model.addAttribute("gender", "M");
        List<Integer> m = List.of();
        model.addAttribute("mylist", m);
        return "condition";
    }

    @GetMapping(value = "serve")
    public String getService(Model m) {
        m.addAttribute("title", "This is title coming form service class");
        m.addAttribute("subtitle", LocalDateTime.now());
        return "service";
    }

    @GetMapping("includefile")
    public String includeFile() {
        return "includefile";
    }

}