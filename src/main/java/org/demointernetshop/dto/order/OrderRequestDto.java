package org.demointernetshop.dto.order;

import lombok.*;
import org.demointernetshop.dto.product.ProductShortInfoDto;
import org.demointernetshop.entity.User;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDto {

    private Integer userId;
    private List<ProductShortInfoDto> products;
}
