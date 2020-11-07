package com.example.domain;

import lombok.*;
import lombok.extern.java.Log;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Categories")
@Data
@Log
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Categories {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long CategoriesId;

   @Column
   private String Categoriesname;

   @OneToMany(mappedBy = "categories", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
   private List<Product> products = new ArrayList<Product>();


}
