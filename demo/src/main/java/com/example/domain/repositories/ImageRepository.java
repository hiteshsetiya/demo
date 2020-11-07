package com.example.domain.repositories;


import java.util.Optional;

import com.example.domain.Image;
import com.example.domain.support.IModelRepo;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface ImageRepository extends IModelRepo, JpaRepository<Image, Long>, JpaSpecificationExecutor<Image> {

  static Specification<Image> equalsAssets(Long id) {
    return (asset, cq, cb) -> cb.equal(asset.get("id"), id);
  }
  Optional<Image> findByName(String name);
}