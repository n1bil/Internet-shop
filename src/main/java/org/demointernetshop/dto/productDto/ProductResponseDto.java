package org.demointernetshop.dto.productDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.demointernetshop.entity.Category;
import org.demointernetshop.entity.Manufacturer;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDto {

    private Integer id;
    private String name;
    private String description;
    private Category category;
    private Manufacturer manufacturer;
    private double productPrice;
    private int productQuantity;
}
