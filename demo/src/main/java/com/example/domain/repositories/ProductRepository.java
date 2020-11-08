package com.example.domain.repositories;


import com.example.domain.Categories;
import com.example.domain.Product;
import com.example.domain.support.IModelRepo;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.*;

public interface ProductRepository extends IModelRepo, JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

    static Specification<Product> equalsProduct(Long productId) {
        return (product, cq, cb) -> cb.equal(product.get("productId"), productId);
    }

    static Specification<Product> hasName(String name) {
        return (product, cq, cb) -> cb.like(product.get("name"), name);
    }

    static Specification<Product> hasColor(String color) {
        return (product, cq, cb) -> cb.like(product.get("color"), "%" + color + "%");
    }

    Optional<Product> findByCategories(Optional<Categories> categories);
}




