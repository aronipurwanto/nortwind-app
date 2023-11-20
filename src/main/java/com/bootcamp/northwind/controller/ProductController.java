package com.bootcamp.northwind.controller;

import com.bootcamp.northwind.model.entity.LookupEntity;
import com.bootcamp.northwind.model.request.CategoriesRequest;
import com.bootcamp.northwind.model.request.ProductRequest;
import com.bootcamp.northwind.model.request.SupplierModel;
import com.bootcamp.northwind.service.CategoryService;
import com.bootcamp.northwind.service.LookupService;
import com.bootcamp.northwind.service.ProductService;
import com.bootcamp.northwind.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Comparator;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;
    private final CategoryService categoryService;
    private final SupplierService supplierService;
    private final LookupService lookupService;

    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("pages/product/index");
        List<ProductRequest> data = this.productService.getAll();
        view.addObject("listProduct", data);
        return view;
    }

    @GetMapping("/add")
    public ModelAndView add(){
        ModelAndView view = new ModelAndView("pages/product/add");
        view.addObject("dataList",lookupService.getByGroups("CATEGORY"));
        view.addObject("byPosition", Comparator.comparing(LookupEntity::getPosition));
        view.addObject("productList", new ProductRequest());
        return view;
    }

    @GetMapping("/add-modal")
    public ModelAndView addModal(){
        ModelAndView view = new ModelAndView("pages/product/_addPartial");
        List<SupplierModel> supplier = this.supplierService.getAll();

        view.addObject("dataSupplier", supplier);
        view.addObject("dataList",lookupService.getByGroups("CATEGORY"));
        view.addObject("byPosition", Comparator.comparing(LookupEntity::getPosition));
        return view;
    }

    @GetMapping("/add-category")
    public ModelAndView addModalCategory(){
        ModelAndView view = new ModelAndView("pages/product/_addCategory");
        view.addObject("dataList",lookupService.getByGroups("CATEGORY"));
        view.addObject("byPosition", Comparator.comparing(LookupEntity::getPosition));
        return view;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute ProductRequest request){
        this.productService.save(request);
        return new ModelAndView("redirect:/product");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/product/edit");
        ProductRequest model = this.productService.getById(id);
        if (model == null){
            return new ModelAndView("redirect:/product");
        }

        List<CategoriesRequest> category = this.categoryService.getAll();
        List<SupplierModel> supplier = this.supplierService.getAll();

        view.addObject("dataCategory", category);
        view.addObject("dataSupplier", supplier);
        view.addObject("listProduct", model);
        return view;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute ProductRequest request){
        this.productService.update(request, request.getId());
        return new ModelAndView("redirect:/product");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/product/detail");
        ProductRequest model = this.productService.getById(id);
        if (model == null){
            return new ModelAndView("redirect:/product");
        }

        view.addObject("listProduct", model);
        return view;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") String id){
        this.productService.delete(id);
        return new ModelAndView("redirect:/product");
    }
}
