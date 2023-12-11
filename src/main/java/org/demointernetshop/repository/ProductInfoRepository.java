package org.demointernetshop.repository;

import org.demointernetshop.dto.product.CategoryWithPricesDto;
import org.demointernetshop.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProductInfoRepository extends JpaRepository<ProductInfo, Integer> {

    @Query("SELECT new org.demointernetshop.dto.product.CategoryWithPricesDto(pi.product.category.id, MIN(pi.price), MAX(pi.price), pi.product.category.categoryName) " +
    "FROM ProductInfo pi " +
    "WHERE pi.product.category.id = :categoryId " +
    "GROUP BY pi.product.category.id, pi.product.category.categoryName")
    Optional<CategoryWithPricesDto> findPriceByCategory(Integer categoryId);

    Optional<ProductInfo> findByProduct_Id(Integer productId);
}
