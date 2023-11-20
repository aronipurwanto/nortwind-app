package com.bootcamp.northwind.controller;

import com.bootcamp.northwind.model.request.CategoriesRequest;
import com.bootcamp.northwind.service.CategoryService;
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

    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("pages/category/index");
        List<CategoriesRequest> data  = this.categoryService.getAll();
        view.addObject("listCategory", data);

        return view;
    }

    @GetMapping("/add-modal")
    public ModelAndView addModal(){
        ModelAndView view = new ModelAndView("pages/category/_addPartial");
        return view;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute CategoriesRequest request){
        // call save dari service
        this.categoryService.save(request);
        // kirim ke index
        return new ModelAndView("redirect:/category");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/category/edit");
        CategoriesRequest data = this.categoryService.getById(id);
        if (data == null){
            return new ModelAndView("redirect:/category");
        }
        // data kirim ke view
        view.addObject("dataCategory", data);
        return view;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute CategoriesRequest request){
        // memanggil save dari service
        this.categoryService.update(request, request.getId());
        // redirect ke index
        return new ModelAndView("redirect:/category");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/category/detail");
        // ambil data dari service
        CategoriesRequest data = this.categoryService.getById(id);
        if ( data == null){
            return new ModelAndView("redirect:/category");
        }

        // kirim data to view
        view.addObject("dataCategory", data);
        return view;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView getDelete(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/category/delete");
        // get data from service
        CategoriesRequest data = this.categoryService.getById(id);
        if(data == null){
            return new ModelAndView("redirect:/category");
        }

        // send data to view
        view.addObject("data",data);
        return view;
    }

    @PostMapping("/delete-save")
    public String delete(@ModelAttribute CategoriesRequest request){
        this.categoryService.delete(request.getId());
        return "redirect:/category";
    }
}
