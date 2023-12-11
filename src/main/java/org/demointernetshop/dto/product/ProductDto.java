package org.demointernetshop.dto.product;


import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {

    private Integer id;
    private String name;
    private String description;
    private CategoryDto category;
    private ManufacturerDto manufacturer;
    private BigDecimal productPrice;
    private Integer productQuantity;
}