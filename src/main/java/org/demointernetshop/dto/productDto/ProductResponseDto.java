package org.demointernetshop.dto.productDto;

import org.demointernetshop.entity.Category;
import org.demointernetshop.entity.Manufacturer;
import org.demointernetshop.entity.ProductInfo;

import java.util.List;

public class ProductResponseDto {

    private Integer id;
    private String name;
    private String description;
    private Category category;
    private Manufacturer manufacturer;
    private List<ProductInfo> productInfos;
}
