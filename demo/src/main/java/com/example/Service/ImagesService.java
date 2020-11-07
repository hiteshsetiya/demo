package com.example.Service;


import com.example.domain.Image;
import com.example.domain.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class ImagesService {

  @Autowired
  private ImageRepository assetRepository;


  public Image persist(Image asset)
          throws Exception {
    return assetRepository.save(asset); // Save to get a id
  }

}


