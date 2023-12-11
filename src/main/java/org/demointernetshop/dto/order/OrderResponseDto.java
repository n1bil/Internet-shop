package org.demointernetshop.dto.order;

import lombok.*;
import org.demointernetshop.dto.product.ProductShortResponseDto;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDto {

    private Integer id;
    private Integer userId;
    private List<ProductShortResponseDto> products;
    private String orderStatus;
    private String payment_status;
    private String paymentMethod;
    private LocalDateTime createData;
}
