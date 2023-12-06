package org.demointernetshop.dto.orderDto;

import org.demointernetshop.entity.CartItem;
import org.demointernetshop.entity.OrderStatus;
import org.demointernetshop.entity.PaymentMethod;
import org.demointernetshop.entity.PaymentStatus;

import java.time.LocalDateTime;
import java.util.List;

public class PlaceOrderResponseDto {

    private Integer userId;
    private List<CartItem> cartItems;
    private OrderStatus orderStatus;
    private PaymentStatus paymentStatus;
    private PaymentMethod paymentMethod;
    private LocalDateTime localDateTime;

}
