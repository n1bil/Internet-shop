package org.demointernetshop.controllers.product;

import lombok.RequiredArgsConstructor;
import org.demointernetshop.dto.product.CategoryDto;
import org.demointernetshop.dto.product.ProductDto;
import org.demointernetshop.dto.product.ProductQuantityResponseDto;
import org.demointernetshop.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        List<ProductDto> allProducts = productService.getAllProducts();

        return ResponseEntity.ok(allProducts);
    }

    @GetMapping("/category/{category_id}")
    public ResponseEntity<List<ProductDto>> getProductsByCategoryAndPrice(@PathVariable("category_id") Integer categoryId,
                                                          @RequestParam(defaultValue = "0") BigDecimal minPrice,
                                                          @RequestParam(defaultValue = "Double.MAX_VALUE") BigDecimal maxPrice) {
        List<ProductDto> productsByCategoryInThePriceRange = productService.getProductsByCategoryInThePriceRange(categoryId, minPrice, maxPrice);

        return ResponseEntity.ok(productsByCategoryInThePriceRange);
    }

    @GetMapping("/category/{category_id}/manufacturer/{manufacturer_id}/price")
    public ResponseEntity<List<ProductDto>> getProductsByCategoryAndManufacturerAndPrice(@PathVariable("category_id") Integer categoryId,
                                                                         @PathVariable("manufacturer_id") Integer manufacturerId,
                                                                         @RequestParam(defaultValue = "0") BigDecimal minPrice,
                                                                         @RequestParam(defaultValue = "Double.MAX_VALUE") BigDecimal maxPrice) {
        List<ProductDto> productsByCategoryByManufacturerInThePriceRange = productService.getProductsByCategoryByManufacturerInThePriceRange(categoryId, manufacturerId, minPrice, maxPrice);

        return ResponseEntity.ok(productsByCategoryByManufacturerInThePriceRange);
    }

    @GetMapping("/{product_id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("product_id") Integer productId){
        ProductDto productById = productService.getProductById(productId);

        return ResponseEntity.ok(productById);
    }

    @GetMapping("/{product_id}/quantity")
    public ResponseEntity<ProductQuantityResponseDto> getProductQuantity(@PathVariable("product_id") Integer productId){
        ProductQuantityResponseDto productQuantity = productService.getProductQuantity(productId);

        return ResponseEntity.ok(productQuantity);
    }




}
