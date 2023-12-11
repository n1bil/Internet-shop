package org.demointernetshop.dto.product;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductShortInfoDto {

    private Integer id;
    private String name;
    private BigDecimal price;
    private Integer quantity;
}
