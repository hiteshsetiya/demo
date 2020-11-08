package com.example.Service;

import com.example.domain.Categories;
import com.example.domain.Image;
import com.example.domain.Product;
import com.example.domain.repositories.CategoriesRepositories;
import com.example.domain.repositories.ImageRepository;
import com.example.domain.repositories.ProductRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static com.example.domain.repositories.ProductRepository.*;
import static org.springframework.data.jpa.domain.Specification.where;

@Log
@Service
@Transactional
public class ProductService {

    @Autowired
    public ProductRepository productRepository;

    @Autowired
    public  CategoriesRepositories categoriesRepositories;


    @Autowired
    public ImageRepository assetRepository;


    @Autowired
    public CategoriesRepositories categories;

    public Product persistProduct(Product product, MultipartFile multipartFile) {
    String contentType = multipartFile.getContentType();
        File file = null;
        file = convertMultiPartToFile(multipartFile);
        if(Objects.nonNull(file)){
            BufferedImage bufferedImage = null;
            try {
                bufferedImage = ImageIO.read(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Image asset = new Image();
    asset.setName(file.getName());
    asset.setDescription(file.getAbsolutePath());
    asset.setWidth(Long.valueOf(bufferedImage.getWidth()));
    asset.setHeight(Long.valueOf(bufferedImage.getHeight()));
    asset.setType(contentType);
    assetRepository.save(asset);
    if(Objects.nonNull(asset)){
        product.setAsset(asset);
    }productRepository.save(product);}
     return product;}

    private File convertMultiPartToFile(MultipartFile file)  {
        File convFile = new File(file.getOriginalFilename());
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(convFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            fos.write(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return convFile;
    }

  public List<Product> searchProduct(String name, String color,Long CategoriesId) {
      Optional<Categories> Categories = categoriesRepositories.findById(CategoriesId);
      Optional<Product> ProductbyCategories = productRepository.findByCategories(Categories);
      List<Product> productList = null;
      if (Objects.nonNull(name) && Objects.nonNull(color) && Objects.nonNull(Categories)) {
      productList = productRepository.findAll(where(hasName(name)).and(hasColor(color)));
    } else if (Objects.nonNull(color)) {
      productList =
          productRepository.findAll(hasColor(color));
    } else if (Objects.nonNull(name)) {
      productList = productRepository.findAll((hasName(name)));
    }
    return productList;
  }




}
