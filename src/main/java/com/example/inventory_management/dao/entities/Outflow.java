package com.example.inventory_management.dao.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Outflow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer outflowCode;
    @NotEmpty
    @Min(0)
    private int outflowQty;
    private Date issueDate;
     @NotNull
     @Min(0)
    private double OutflowPrice;

    @ManyToOne
    public Product product;


}

