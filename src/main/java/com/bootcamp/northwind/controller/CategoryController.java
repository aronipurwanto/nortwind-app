package com.bootcamp.northwind.controller;

import com.bootcamp.northwind.model.request.CategoriesRequest;
import com.bootcamp.northwind.model.request.SupplierModel;
import com.bootcamp.northwind.service.CategoryService;
import com.bootcamp.northwind.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;
    private final SupplierService supplierService;

    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("pages/category/index");
        List<CategoriesRequest> categories = this.categoryService.getAll();

        view.addObject("listCategory", categories);
        return view;
    }

    @GetMapping("/add-modal")
    public ModelAndView addModal(){
        ModelAndView view = new ModelAndView("pages/category/_addPartial");
        List<SupplierModel> supplier = this.supplierService.getAll();

        view.addObject("listSupplier", supplier);
        return view;
    }

    @GetMapping("/add-product/{index}")
    public ModelAndView addProduct(@PathVariable("index") int index){
        ModelAndView view = new ModelAndView("pages/category/_addProduct");
        List<SupplierModel> supplier = this.supplierService.getAll();

        view.addObject("listSupplier", supplier);
        view.addObject("index", index);
        return view;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute CategoriesRequest request){
        this.categoryService.save(request);
        return new ModelAndView("redirect:/category");
    }
}
