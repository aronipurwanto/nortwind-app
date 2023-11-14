package com.bootcamp.northwind.controller;

import com.bootcamp.northwind.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private ProductService productService;

}
