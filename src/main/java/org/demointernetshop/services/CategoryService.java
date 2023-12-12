package org.demointernetshop.services;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.demointernetshop.dto.product.CategoryDto;
import org.demointernetshop.dto.product.CategoryWithPricesDto;
import org.demointernetshop.mapper.CategoryMapper;
import org.demointernetshop.repository.CategoryRepository;
import org.demointernetshop.repository.ProductInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class CategoryService {

    private CategoryRepository categoryRepository;
    private ProductInfoRepository productInfoRepository;
    private CategoryMapper categoryMapper;

    public List<CategoryDto> getAllCategory(){

        return categoryRepository.findAll().stream()
                .map(categoryMapper::mapToCategoryDto)
                .collect(Collectors.toList());
    }

    public CategoryWithPricesDto getCategoryWithPrices(Integer categoryId) {
       /*
       1. Создать объект, который будет содержать id категории, минимальную цену в этой категории, максимальную цену товара в этой категории и название категории
       2. Определить минимальную цену товаров в этой категории
       3. Определить максимальную цену товаров в этой категории
       4. Вытащить название категории из таблицы
        */

//        List<ProductInfo> productInfos = productInfoRepository.findAll();
//
//        BigDecimal minPrice = productInfos.stream()
//                .filter(productInfo -> productInfo.getProduct().getCategory().getId().equals(categoryId))
//                .map(productInfo -> productInfo.getPrice())
//                .min(Comparator.naturalOrder())
//                .orElse(null);
//
//        BigDecimal maxPrice = productInfos.stream()
//                .filter(productInfo -> productInfo.getProduct().getCategory().getId().equals(categoryId))
//                .map(productInfo -> productInfo.getPrice())
//                .max(Comparator.naturalOrder())
//                .orElse(null);
//
//        String categoryName = categoryRepository.findById(categoryId).get().getCategoryName();
//
//        return new CategoryWithPricesDto(categoryId,minPrice,maxPrice, categoryName);


        return productInfoRepository.findPriceByCategory(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found or no products in the category"));

    }
}
