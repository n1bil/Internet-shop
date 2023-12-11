package org.demointernetshop.dto.product;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CategoryWithPricesDto {

    private Integer id;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
    private String categoryName;
}
