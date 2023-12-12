package org.demointernetshop.controllers.product;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.demointernetshop.dto.product.CategoryDto;
import org.demointernetshop.dto.product.CategoryWithPricesDto;
import org.demointernetshop.dto.product.ProductDto;
import org.demointernetshop.services.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/products/category")
public class CategoryController {

    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategory(){
        List<CategoryDto> allCategory = categoryService.getAllCategory();

        return ResponseEntity.ok(allCategory);
    }

    @GetMapping("/{category_id}/price")
    public ResponseEntity<CategoryWithPricesDto> getCategoryWithPrices(@PathVariable("category_id") Integer categoryId) {
        CategoryWithPricesDto categoryWithPrices = categoryService.getCategoryWithPrices(categoryId);

        return ResponseEntity.ok(categoryWithPrices);
    }


}
