package com.example.Controller;



import com.example.Service.ProductService;
import com.example.domain.Categories;
import com.example.domain.Product;
import com.example.domain.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/productTasks")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    List<Product> getProduct() {
        return productRepository.findAll();
    }

    @PostMapping("/products")
     Product saveProduct(@RequestPart("product") Product product,@RequestPart("file") MultipartFile file) throws Exception {
        return productService.persistProduct(product,file);
    }

       @GetMapping("/products/name")
       List<Product> SearchByNameColor(@RequestParam("name") Optional<String> name, @RequestParam("color") Optional<String>  color, @RequestParam("categoriesId") Optional<Long> categoriesId){
           List<Product> names = productService.searchProduct(name.get(),color.get(),categoriesId.get());
           return names;
       }





}
