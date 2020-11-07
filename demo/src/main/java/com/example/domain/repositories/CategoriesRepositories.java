package com.example.domain.repositories;


import com.example.domain.Categories;
import com.example.domain.support.IModelRepo;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CategoriesRepositories extends IModelRepo, JpaRepository<Categories, Long>, JpaSpecificationExecutor<Categories> {

    static Specification<Categories> equalsCategorie(Long categoriesId) {
        return (categories, cq, cb) -> cb.equal(categories.get("categoriesId"), categoriesId);
    }

}
