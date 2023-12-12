package org.demointernetshop.services;

import lombok.AllArgsConstructor;
import org.demointernetshop.dto.order.OrderRequestDto;
import org.demointernetshop.dto.order.OrderResponseDto;
import org.demointernetshop.entity.Cart;
import org.demointernetshop.entity.Order;
import org.demointernetshop.entity.OrderItem;
import org.demointernetshop.entity.User;
import org.demointernetshop.mapper.OrderMapper;
import org.demointernetshop.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class OrderService {

    private OrderRepository orderRepository;
    private CartRepository cartRepository;
    private UserRepository userRepository;
    private OrderMapper orderMapper;
    private OrderStatusRepository orderStatusRepository;
    private PaymentMethodRepository paymentMethodRepository;
    private PaymentStatusRepository paymentStatusRepository;

    public OrderResponseDto createOrder(Integer cartId, OrderRequestDto request) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new IllegalArgumentException("Cart not found"));
        User user = userRepository.findById(request.getUserId()).orElseThrow(() -> new RuntimeException("Cart not found"));

        Order newOrder = Order.builder()
                .user(user)
                .orderStatus(orderStatusRepository.findByStatus("PROCESSING").orElseThrow())
                .paymentStatus(paymentStatusRepository.findByStatus("PAID").orElseThrow())
                .paymentMethod(paymentMethodRepository.findByMethod("BY_CASH").orElseThrow())
                .build();

        List<OrderItem> orderItems = orderMapper.mapToOrderItems(cart.getCartItems(), newOrder);
        newOrder.setOrderItems(orderItems);

        Order savedOrder = orderRepository.save(newOrder);

        return orderMapper.mapToOrderResponseDto(savedOrder);

    }

    public void deleteOrder(Integer orderId) {
        orderRepository.deleteById(orderId);
    }

}