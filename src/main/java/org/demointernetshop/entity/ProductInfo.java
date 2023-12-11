package org.demointernetshop.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.mapping.ToOne;

import java.math.BigDecimal;


@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private BigDecimal price;
    private int quantity;

}
