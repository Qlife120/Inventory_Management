package com.example.inventory_management.dao.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
    @NotEmpty
    @Size(max = 100)
    private String categoryName;
    @NotEmpty
    private String categoryDesignation;

    @OneToMany(mappedBy = "category")
    private List<Product> products = new ArrayList<Product>();


    
}
