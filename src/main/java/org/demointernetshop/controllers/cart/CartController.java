package org.demointernetshop.controllers.cart;

import lombok.RequiredArgsConstructor;
import org.demointernetshop.dto.cart.CartChangeRequestDto;
import org.demointernetshop.dto.cart.CartDto;
import org.demointernetshop.services.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class CartController {

    private final CartService cartService;

    @GetMapping("/{user_id}/cart")
    public ResponseEntity<CartDto> getCart(@PathVariable("user_id") Integer userId) {
        CartDto cart = cartService.getCart(userId);

        return ResponseEntity.ok(cart);
    }

    @PutMapping("/{user_id}/cart")
    public ResponseEntity<CartDto> updateCart(@PathVariable("user_id") Integer userId,
                                              @RequestBody CartChangeRequestDto request) {
        CartDto cart = cartService.updateCart(userId, request);

        return ResponseEntity.ok(cart);
    }
}
