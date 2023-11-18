package com.bootcamp.northwind.controller;

import com.bootcamp.northwind.model.entity.LookupEntity;
import com.bootcamp.northwind.model.request.ProductsRequest;
import com.bootcamp.northwind.service.CategoryService;
import com.bootcamp.northwind.service.LookupService;
import com.bootcamp.northwind.service.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductsController {
    private final ProductsService productsService;
    private final LookupService lookupService;

    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("pages/products/index");
        List<ProductsRequest> products = this.productsService.getAll();

        view.addObject("productList", products);
        return view;
    }

    @GetMapping("/add")
    public ModelAndView add(){
        ModelAndView view = new ModelAndView("pages/products/add");
        view.addObject("dataList",lookupService.getByGroup("CATEGORY"));
        view.addObject("byPosition", Comparator.comparing(LookupEntity::getPosition));
        view.addObject("productList", new ProductsRequest());
        return view;
    }

    @GetMapping("/add-modal")
    public ModelAndView addModal(){
        ModelAndView view = new ModelAndView("pages/products/_addPartial");
        view.addObject("dataList",lookupService.getByGroup("CATEGORY"));
        view.addObject("byPosition", Comparator.comparing(LookupEntity::getPosition));
        return view;
    }

    @GetMapping("/add-category")
    public ModelAndView addModalCategory(){
        ModelAndView view = new ModelAndView("pages/products/_addCategory");
        view.addObject("dataList",lookupService.getByGroup("CATEGORY"));
        view.addObject("byPosition", Comparator.comparing(LookupEntity::getPosition));
        return view;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute ProductsRequest request){
        this.productsService.save(request);
        return new ModelAndView("redirect:/products");
    }

    @PostMapping("/save-category")
    public ModelAndView saveCategory(@ModelAttribute ProductsRequest request){
        this.productsService.save(request);
        return new ModelAndView("redirect:/products");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/products/edit");
        ProductsRequest category = this.productsService.getById(id).orElse(null);
        if (category == null){
            return new ModelAndView("redirect:/products");
        }

        view.addObject("category", category);
        return view;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute ProductsRequest request){
        this.productsService.update(request, request.getId());
        return new ModelAndView("redirect:/products");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/products/delete");
        //get data from category service
        ProductsRequest category = this.productsService.getById(id).orElse(null);
        if (category == null){
            return new ModelAndView("redirect:/products");
        }
        view.addObject("category",category);
        return view;
    }

    @PostMapping("/delete-save")
    public String delete(@ModelAttribute ProductsRequest request){
        this.productsService.delete(request.getId());
        return "redirect:/products";
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id")String id){
        ModelAndView view = new ModelAndView("pages/products/detail");
        ProductsRequest category = this.productsService.getById(id).orElse(null);
        if (category == null){
            return new ModelAndView("redirect:/products");
        }

        view.addObject("category", category);
        return view;
    }
}
