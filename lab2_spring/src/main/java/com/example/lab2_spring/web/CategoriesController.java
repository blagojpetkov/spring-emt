package com.example.lab2_spring.web;

import com.example.lab2_spring.model.Category;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RequestMapping("/categories")
@RestController
@CrossOrigin
public class CategoriesController {

    @GetMapping
    public List<Category> getCategories(){
        return Arrays.asList(Category.values()) ;
    }
}
