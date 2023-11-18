package com.bootcamp.northwind.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index(){
        return "pages/home/index";
    }

    @GetMapping("/home")
    public String home(){
        return "pages/home/index";
    }
}
