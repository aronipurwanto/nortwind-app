//package com.bootcamp.northwind.controller;
//
//import com.bootcamp.northwind.model.entity.CategoryEntity;
//import com.bootcamp.northwind.model.entity.LookupEntity;
//import com.bootcamp.northwind.model.request.ProductsRequest;
//import com.bootcamp.northwind.model.request.SupplierRequest;
//import com.bootcamp.northwind.service.CategoryService;
//import com.bootcamp.northwind.service.LookupService;
//import com.bootcamp.northwind.service.ProductsService;
//import com.bootcamp.northwind.service.SupplierService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.Comparator;
//import java.util.List;
//
//@Controller
//@RequestMapping("/products")
//@RequiredArgsConstructor
//public class ProductsController {
//    private final ProductsService productsService;
//    private final SupplierService supplierService;
//    private final LookupService lookupService;
//    private final CategoryService categoryService;
//
//    @GetMapping
//    public ModelAndView index(){
//        ModelAndView view = new ModelAndView("pages/products/index");
//        List<ProductsRequest> products = this.productsService.getAll();
//
//        view.addObject("productList", products);
//        return view;
//    }
//
//    // add partial  pop-up
//    @GetMapping("/add-modal")
//    public ModelAndView addModal(){
//        ModelAndView view = new ModelAndView("pages/products/_addPartial");
//        List<SupplierRequest> supplier = this.supplierService.getAll();
//
//        view.addObject("supplierList", supplier);
//        view.addObject("dataList",categoryService.getAll());
//        view.addObject("products", new ProductsRequest());
//        return view;
//    }
//
//    @GetMapping("/add-category/{index}")
//    public ModelAndView addModalCategory(@PathVariable("index")int index){
//        ModelAndView view = new ModelAndView("pages/products/_addCategory");
//        view.addObject("dataList",categoryService.getAll());
//        view.addObject("index", index);
//        return view;
//    }
//
//    @PostMapping("/save")
//    public ModelAndView save(@ModelAttribute ProductsRequest request){
//        this.productsService.save(request);
//        return new ModelAndView("redirect:/products");
//    }
//
//    @GetMapping("/edit/{id}")
//    public ModelAndView edit(@PathVariable("id") Long id){
//        ModelAndView view = new ModelAndView("pages/products/edit");
//        ProductsRequest products = this.productsService.getById(id).orElse(null);
//        if (products == null){
//            return new ModelAndView("redirect:/products");
//        }
//
//        List<SupplierRequest> supplier = this.supplierService.getAll();
//
//        view.addObject("supplierList", supplier);
//        view.addObject("dataList",lookupService.getByGroup("CATEGORY"));
//        view.addObject("byPosition", Comparator.comparing(LookupEntity::getPosition));
//        view.addObject("products", products);
//        return view;
//    }
//
//    @PostMapping("/update")
//    public ModelAndView update(@ModelAttribute ProductsRequest request){
//        this.productsService.update(request, request.getId());
//        return new ModelAndView("redirect:/products");
//    }
//
//    @GetMapping("/delete/{id}")
//    public ModelAndView delete(@PathVariable("id") Long id){
//        ModelAndView view = new ModelAndView("pages/products/delete");
//        //get data from category service
//        ProductsRequest products = this.productsService.getById(id).orElse(null);
//        if (products == null){
//            return new ModelAndView("redirect:/products");
//        }
//        view.addObject("products",products);
//        return view;
//    }
//
//    // delete pop-up
//    @PostMapping("/delete-save")
//    public String delete(@ModelAttribute ProductsRequest request){
//        this.productsService.delete(request.getId());
//        return "redirect:/products";
//    }
//
//    // detail pop-up
//    @GetMapping("/detail/{id}")
//    public ModelAndView detail(@PathVariable("id")Long id){
//        ModelAndView view = new ModelAndView("pages/products/detail");
//        ProductsRequest product = this.productsService.getById(id).orElse(null);
//        if (product == null){
//            return new ModelAndView("redirect:/products");
//        }
//
//        view.addObject("product", product);
//        return view;
//    }
//}
