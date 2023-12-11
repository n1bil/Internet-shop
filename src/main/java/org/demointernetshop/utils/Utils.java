package org.demointernetshop.utils;

import org.demointernetshop.dto.product.ProductShortInfoDto;

import java.math.BigDecimal;
import java.util.List;

public class Utils {

    public static BigDecimal calculateTotalAmount(List<ProductShortInfoDto> products) {
        return products.stream()
                .map(product -> product.getPrice().multiply(BigDecimal.valueOf(product.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
