package com.example.inventory_management.dao.entities;

// Information relative to a specific item being ordered

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderlineId;
    private int  quantityOrdered;
    private double totalAmount;
    @ManyToOne
    private Product product;

    @ManyToOne
    private Order order;

}
