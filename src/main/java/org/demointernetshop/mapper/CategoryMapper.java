package org.demointernetshop.mapper;

import org.demointernetshop.dto.product.CategoryDto;
import org.demointernetshop.entity.Category;

public class CategoryMapper {

    public CategoryDto mapToCategoryDto(Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .categoryName(category.getCategoryName())
                .build();
    }
}
