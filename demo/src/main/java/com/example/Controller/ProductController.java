package com.example.Controller;



import com.example.Service.ProductService;
import com.example.domain.Categories;
import com.example.domain.Product;
import com.example.domain.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping(path = "/productTasks")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    List<Product> all() {
        return productRepository.findAll();
    }

    @PostMapping("/products")
     Product saveProduct(@RequestPart("product") Product product,@RequestPart("file") MultipartFile file) throws Exception {
        return productService.persistProduct(product,file);
    }

       @GetMapping("/products/name")
       List<Product> getName(String name, String color,  Long categorieId){
           List<Product> names = productService.findName(name, color,categorieId);
           return names;
       }





}
