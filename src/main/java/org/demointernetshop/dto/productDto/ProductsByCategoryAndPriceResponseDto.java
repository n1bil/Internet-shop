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
public class ProductsByCategoryAndPriceResponseDto {

    private Integer id;
    private String product_name;
    private String description;
    private Category category;
    private Manufacturer manufacturer;
    private int product_price;
    private int product_quantity;

}
