package com.example.inventory_management.dao.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
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
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productCode;
    @NotEmpty
    @Size(max = 100)
    private String productName;
    private String designation;
    @Min(0)
    private int quantity;
    @Min(0)
    private double price;
    @NotEmpty
    @Size(max = 100)
    private String barcode;

    @ManyToOne()
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<OrderLine> orderLineList  = new ArrayList<OrderLine>();

    @OneToMany(mappedBy = "product")
    private List<Receipt> receptions = new ArrayList<Receipt>();

    @OneToMany(mappedBy = "product")
    private List<Outflow> outflows = new ArrayList<Outflow>();

    @ManyToOne
   private Stockroom stockroom;

    @ManyToOne
    private Supplier supplier;

    public Product(Integer productCode,String productName, String designation, double price, int quantity, String barcode, Category category) {
        this.productCode = productCode;
        this.productName = productName;
        this.designation = designation;
        this.price = price;
        this.quantity = quantity;
        this.barcode = barcode;
        this.category = category;
    }


}
