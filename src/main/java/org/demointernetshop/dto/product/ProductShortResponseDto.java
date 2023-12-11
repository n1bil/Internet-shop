package org.demointernetshop.dto.product;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductShortResponseDto {

    private Integer id;
    private String name;
    private String description;
    private BigDecimal productPrice;
    private Integer productQuantity;
}
