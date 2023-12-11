package org.demointernetshop.mapper;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.demointernetshop.dto.product.ProductDto;
import org.demointernetshop.entity.Product;

@AllArgsConstructor
@NoArgsConstructor
public class ProductMapper {

    private CategoryMapper categoryMapper;
    private ManufacturerMapper manufacturerMapper;

    public ProductDto mapToProductDto(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .category(categoryMapper.mapToCategoryDto(product.getCategory()))
                .manufacturer(manufacturerMapper.mapToManufacturerDto(product.getManufacturer()))
                .build();
    }

}
