package org.demointernetshop.dto.productDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryByRangeResponseDto {

    private Integer id;
    private String categoryName;
    private int minPrice;
    private int maxPrice;

}
