package com.example.inventory_management.dao.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Receipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer receiptCode;
    @NotNull
    @Min(0)
    private int quantityRecieved;
    private Date receiptionDate;
    @Min(0)
    @NotNull
    private double Receiptprice;
    private boolean isdeleted = false;

    @ManyToOne
    public Product product;
}
