package org.demointernetshop.dto.orderDto;

import org.demointernetshop.entity.OrderItem;
import org.demointernetshop.entity.OrderStatus;

import java.math.BigDecimal;
import java.util.List;

public class OrderResponseDto {

    private Integer id;
    private List<OrderItem> orderItems;
    private BigDecimal totalAmount;
    private OrderStatus orderStatus;

}
