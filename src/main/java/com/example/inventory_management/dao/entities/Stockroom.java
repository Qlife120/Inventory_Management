package com.example.inventory_management.dao.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Stockroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer  stockroomCode;
    @Max(100)
    private String stockroomName;

    @OneToMany(mappedBy = "stockroom", cascade = CascadeType.ALL)
    public List<Product> products = new ArrayList<Product>();

}
