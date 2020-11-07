package com.example.Controller;

import com.example.Service.CategorieService;
import com.example.domain.Categories;
import com.example.domain.repositories.CategoriesRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/categorieTasks")
public class CategorieController {


    @Autowired
    private CategorieService categorieService;

    @Autowired
    private CategoriesRepositories categoriesRepositories;

    @GetMapping("/categorie")
    List<Categories> all() {
        return  categoriesRepositories.findAll();
    }

    @PostMapping("/categorie")
    Categories saveProduct(@RequestBody Categories categories) {
        return categorieService.persistCategorie(categories);
    }
}
