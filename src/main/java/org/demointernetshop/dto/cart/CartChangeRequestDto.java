package org.demointernetshop.dto.cart;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CartChangeRequestDto {

    private Integer product_id;
    private Integer count;
}
