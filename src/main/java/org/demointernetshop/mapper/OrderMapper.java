package org.demointernetshop.mapper;

import org.demointernetshop.dto.order.OrderResponseDto;
import org.demointernetshop.dto.product.ProductShortResponseDto;
import org.demointernetshop.entity.CartItem;
import org.demointernetshop.entity.Order;
import org.demointernetshop.entity.OrderItem;

import java.util.List;
import java.util.stream.Collectors;

public class OrderMapper {

    public List<OrderItem> mapToOrderItems(List<CartItem> cartItems) {
        return cartItems.stream()
                .map(cartItem -> OrderItem.builder()
                        .product(cartItem.getProduct())
                        .quantity(cartItem.getQuantity())
                        .price(cartItem.getProduct().getProductInfo().getPrice())
                        .build())
                .collect(Collectors.toList());
    }

    public OrderResponseDto mapToOrderResponseDto(Order order) {
        return new OrderResponseDto(
                order.getId(),
                order.getUser().getId(),
                mapToProductShortInfoDtoList(order.getOrderItems()),
                order.getOrderStatus().getStatus(),
                order.getPaymentStatus().getStatus(),
                order.getPaymentMethod().getMethod(),
                order.getCreateData()
        );
    }

    public List<ProductShortResponseDto> mapToProductShortInfoDtoList(List<OrderItem> orderItems) {
        return orderItems.stream()
                .map(orderItem -> new ProductShortResponseDto(
                        orderItem.getProduct().getId(),
                        orderItem.getProduct().getName(),
                        orderItem.getProduct().getDescription(),
                        orderItem.getPrice(),
                        orderItem.getQuantity()
                ))
                .collect(Collectors.toList());
    }

}
