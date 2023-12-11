package org.demointernetshop.dto.cart;

import lombok.*;
import org.demointernetshop.dto.product.ProductShortInfoDto;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartDto {

    private Integer id;
    private Integer userId;
    private List<ProductShortInfoDto> products;
}
