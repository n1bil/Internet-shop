package org.demointernetshop.services;

import lombok.AllArgsConstructor;
import org.demointernetshop.dto.product.ProductDto;
import org.demointernetshop.dto.product.ProductQuantityResponseDto;
import org.demointernetshop.entity.ProductInfo;
import org.demointernetshop.exception.NotFoundException;
import org.demointernetshop.mapper.ProductMapper;
import org.demointernetshop.repository.ProductInfoRepository;
import org.demointernetshop.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService {

    private ProductRepository productRepository;
    private ProductMapper productMapper;
    private ProductInfoRepository productInfoRepository;

    public List<ProductDto> getAllProducts() {
        return productRepository.findAll().stream()
                .map(productMapper::mapToProductDto)
                .collect(Collectors.toList());
    }

    public List<ProductDto> getProductsByCategoryInThePriceRange(Integer categoryId, BigDecimal minPrice, BigDecimal maxPrice) {
        return productRepository.findByCategory_IdAndProductInfo_PriceBetween(categoryId, minPrice, maxPrice)
                .stream()
                .map(productMapper::mapToProductDto)
                .collect(Collectors.toList());

    }

    public List<ProductDto> getProductsByCategoryByManufacturerInThePriceRange(Integer categoryId, Integer manufacturerId, BigDecimal minPrice, BigDecimal maxPrice) {
        return productRepository.findByCategory_IdAndManufacturer_IdAndProductInfo_PriceBetween(categoryId, manufacturerId,minPrice, maxPrice)
                .stream()
                .map(productMapper::mapToProductDto)
                .collect(Collectors.toList());

    }

    public ProductDto getProductById(Integer productId) {
        return productRepository.findById(productId)
                .map(productMapper::mapToProductDto)
                .orElseThrow(() -> new NotFoundException("Product with id " + productId + " not found"));
    }

    public ProductQuantityResponseDto getProductQuantity(Integer productId) {
        Optional<ProductInfo> productById = productInfoRepository.findByProduct_Id(productId);
        Integer quantity = productById.map(ProductInfo::getQuantity).orElse(0);

        return ProductQuantityResponseDto.builder()
                .quantity(quantity).build();
    }
}
