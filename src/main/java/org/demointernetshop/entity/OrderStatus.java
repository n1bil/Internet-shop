package org.demointernetshop.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class OrderStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String orderStatus;

    @OneToMany(mappedBy = "orderStatus")
    private List<Order> orders;
}
