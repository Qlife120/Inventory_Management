package com.example.inventory_management.dao.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer supplierCode;
    @NotNull
    private  String supplierName;
    @Max(100)
    private String supplierAddress;
    @Min(10)
    private String phoneNumber;
    @Pattern(regexp = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}", message = "Invalid email address")
    private String supplierEmail;

    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL)
    public List<Product> products = new ArrayList<Product>();



}
