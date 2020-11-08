package com.example.Service;

import com.example.domain.Categories;
import com.example.domain.Product;
import com.example.domain.repositories.CategoriesRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class CategorieService {

@Autowired
    CategoriesRepositories categoriesRepositories;

    public Categories persistCategorie(Categories categories) {
        categoriesRepositories.save(categories);
        return categories;
    }




}
