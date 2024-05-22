package com.example.inventory_management.dao.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name="Command")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer orderId;
    private Date orderDate;
    private String status;

    @OneToMany(mappedBy = "order")
    public List<OrderLine> orderLineList = new ArrayList<OrderLine>();

}
