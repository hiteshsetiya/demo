package com.example.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.extern.java.Log;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"color", "name"}))
@Data
@Log
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "fk_asset_id")
    private Image asset;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_categories_Id")
    @JsonIgnore
    private Categories categories;

    @Column
    private String color;

    @Column
    private String price;
}
