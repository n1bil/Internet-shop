package org.demointernetshop.controllers.order;

import lombok.RequiredArgsConstructor;
import org.demointernetshop.dto.order.OrderResponseDto;
import org.demointernetshop.dto.order.OrderRequestDto;
import org.demointernetshop.services.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/{cart_id}")
    public ResponseEntity<OrderResponseDto> createOrder(@PathVariable("cart_id") Integer cartId,
                                                       @RequestBody OrderRequestDto request){
        OrderResponseDto order = orderService.createOrder(cartId, request);

        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    @DeleteMapping("{order_id}")
    public ResponseEntity<String> deleteOrder(@PathVariable("order_id") Integer orderId){
        orderService.deleteOrder(orderId);

        return new ResponseEntity<>("Order with id " + orderId + " successfully deleted", HttpStatus.OK);
    }
}
