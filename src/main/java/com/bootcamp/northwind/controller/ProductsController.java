package com.bootcamp.northwind.controller;

import com.bootcamp.northwind.model.entity.LookupEntity;
import com.bootcamp.northwind.model.request.CategoryRequest;
import com.bootcamp.northwind.service.CategoryService;
import com.bootcamp.northwind.service.LookupService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    private final LookupService lookupService;

    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("pages/category/index");
        List<CategoryRequest> category = this.categoryService.getAll();

        view.addObject("categoryList", category);
        return view;
    }

    @GetMapping("/add")
    public ModelAndView add(){
        ModelAndView view = new ModelAndView("pages/category/add");
        view.addObject("dataList",lookupService.getByGroup("CATEGORY"));
        view.addObject("byPosition", Comparator.comparing(LookupEntity::getPosition));
        view.addObject("categoryList", new CategoryRequest());
        return view;
    }

    @GetMapping("/add-modal")
    public ModelAndView addModal(){
        ModelAndView view = new ModelAndView("pages/category/_addPartial");
        view.addObject("dataList",lookupService.getByGroup("CATEGORY"));
        view.addObject("byPosition", Comparator.comparing(LookupEntity::getPosition));
        return view;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute CategoryRequest request){
        this.categoryService.save(request);
        return new ModelAndView("redirect:/category");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/category/edit");
        CategoryRequest category = this.categoryService.getById(id).orElse(null);
        if (category == null){
            return new ModelAndView("redirect:/category");
        }

        view.addObject("category", category);
        return view;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute CategoryRequest request){
        this.categoryService.update(request, request.getId());
        return new ModelAndView("redirect:/category");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/category/delete");
        //get data from category service
        CategoryRequest category = this.categoryService.getById(id).orElse(null);
        if (category == null){
            return new ModelAndView("redirect:/category");
        }
        view.addObject("category",category);
        return view;
    }

    @PostMapping("/delete-save")
    public String delete(@ModelAttribute CategoryRequest request){
        this.categoryService.delete(request.getId());
        return "redirect:/category";
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id")String id){
        ModelAndView view = new ModelAndView("pages/category/detail");
        CategoryRequest category = this.categoryService.getById(id).orElse(null);
        if (category == null){
            return new ModelAndView("redirect:/category");
        }

        view.addObject("category", category);
        return view;
    }
}
