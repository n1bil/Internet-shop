package org.demointernetshop.repository;

import org.demointernetshop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByCategory_IdAndProductInfo_PriceBetween(Integer categoryId, BigDecimal minPrice, BigDecimal maxPrice);

    List<Product> findByCategory_IdAndManufacturer_IdAndProductInfo_PriceBetween(Integer categoryId, Integer manufacturerId, BigDecimal minPrice, BigDecimal maxPrice);



}
