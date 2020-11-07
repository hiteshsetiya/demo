package com.example.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;


@Entity
@Table(name = "image")
@Data
@ToString
@EqualsAndHashCode()
public class Image {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Column
  private String name;
  @Column
  private String type;
  @Column
  private String description;
  @Column
  private Long height;
  @Column
  private Long width;

}
