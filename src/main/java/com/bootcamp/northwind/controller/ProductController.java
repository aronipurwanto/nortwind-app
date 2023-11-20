package com.bootcamp.northwind.controller;

import com.bootcamp.northwind.model.entity.CategoryEntity;
import com.bootcamp.northwind.model.response.CategoryResponse;
import com.bootcamp.northwind.model.response.ProductResponse;
import com.bootcamp.northwind.model.response.SupplierResponse;
import com.bootcamp.northwind.service.CategoryService;
import com.bootcamp.northwind.service.ProductService;
import com.bootcamp.northwind.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Controller
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;
    private final CategoryService categoryService;
    private final SupplierService supplierService;

    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("pages/product/index");
        List<ProductResponse> requests = productService.getAll();

        view.addObject("dataProduct", requests);
        return view;
    }

    @GetMapping("/add-modal")
    public ModelAndView addModel(){
        ModelAndView view = new ModelAndView("pages/product/add");

        List<CategoryResponse> category = categoryService.getAll();
        List<SupplierResponse> supplier = supplierService.getAll();

        view.addObject("supplier", supplier);
        view.addObject("category", category);
        return view;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute ProductResponse response){
        productService.save(response);
        return new ModelAndView("redirect:/product");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/product/edit");
        ProductResponse response = productService.getById(id);
        if (response == null){
            return new ModelAndView("redirect:/product");
        }

        List<CategoryResponse> category = categoryService.getAll();

        List<SupplierResponse> supplier = supplierService.getAll();

        view.addObject("editSupplier", supplier);

        view.addObject("editCategory", category);

        view.addObject("editProduct", response);
        return view;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute ProductResponse response){
        productService.update(response, response.getId());
        return new ModelAndView("redirect:/product");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/product/delete");
        ProductResponse response = productService.getById(id);
        if (response == null){
            return new ModelAndView("redirect:/product");
        }

        view.addObject("product", response);
        return view;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") String id) {
        ModelAndView view = new ModelAndView("pages/product/detail");
        ProductResponse response = productService.getById(id);
        if (response == null) {
            return new ModelAndView("redirect:/product");
        }
        view.addObject("detailProduct", response);
        return view;
    }

    @PostMapping("/delete-save")
    public String delete(@ModelAttribute ProductResponse response){
        productService.delete(response.getId());
        return "redirect:/product";
    }
}

