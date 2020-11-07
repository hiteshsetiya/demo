package com.example.Controller;


import com.example.Service.ImagesService;
import com.example.domain.Image;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;


@Controller
@Log
public class ImageController  {

  @Autowired
  private ImagesService imagesService;

  @PostMapping(path = "/assets")
  @ResponseStatus(HttpStatus.OK)
  public String saveImage(Image asset) throws Exception {
    imagesService.persist(asset);
    return "ok";
  }

}












