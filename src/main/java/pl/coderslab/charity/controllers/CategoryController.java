package pl.coderslab.charity.controllers;

import org.springframework.stereotype.Controller;
import pl.coderslab.charity.services.CategoryService;

@Controller
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


}

