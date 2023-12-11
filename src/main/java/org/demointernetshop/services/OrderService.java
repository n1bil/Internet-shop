package org.demointernetshop.services;

import lombok.AllArgsConstructor;
import org.demointernetshop.dto.order.OrderRequestDto;
import org.demointernetshop.dto.order.OrderResponseDto;
import org.demointernetshop.entity.Cart;
import org.demointernetshop.entity.Order;
import org.demointernetshop.mapper.OrderMapper;
import org.demointernetshop.repository.*;
import org.springframework.stereotype.Service;

import static org.demointernetshop.utils.Utils.calculateTotalAmount;


@Service
@AllArgsConstructor
public class OrderService {

    private OrderRepository orderRepository;
    private CartRepository cartRepository;
    private OrderMapper orderMapper;
    private OrderStatusRepository orderStatusRepository;
    private PaymentMethodRepository paymentMethodRepository;
    private PaymentStatusRepository paymentStatusRepository;

    public OrderResponseDto createOrder(Integer cartId, OrderRequestDto request) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new IllegalArgumentException("Cart not found"));

        Order newOrder = Order.builder()
                .user(request.getUser())
                .orderItems(orderMapper.mapToOrderItems(cart.getCartItems()))
                .totalAmount(calculateTotalAmount(request.getProducts()))
                .orderStatus(orderStatusRepository.findByStatus("PROCESSING").orElseThrow())
                .paymentStatus(paymentStatusRepository.findByStatus("PAID").orElseThrow())
                .paymentMethod(paymentMethodRepository.findByMethod("BY_CASH").orElseThrow())
                .build();

        Order savedOrder = orderRepository.save(newOrder);

        return orderMapper.mapToOrderResponseDto(savedOrder);

    }

    public void deleteOrder(Integer cartId) {
        cartRepository.deleteById(cartId);
    }

}
