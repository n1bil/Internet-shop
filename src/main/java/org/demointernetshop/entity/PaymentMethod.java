package org.demointernetshop.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class PaymentMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String method;

    @OneToMany(mappedBy = "paymentMethod")
    private List<Order> orders;
}
