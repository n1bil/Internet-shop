package org.demointernetshop.services;

import lombok.AllArgsConstructor;
import org.demointernetshop.dto.cart.CartChangeRequestDto;
import org.demointernetshop.dto.cart.CartDto;
import org.demointernetshop.dto.product.ProductDto;
import org.demointernetshop.dto.product.ProductShortInfoDto;
import org.demointernetshop.entity.Cart;
import org.demointernetshop.entity.CartItem;
import org.demointernetshop.entity.Product;
import org.demointernetshop.entity.User;
import org.demointernetshop.exception.NotFoundException;
import org.demointernetshop.mapper.CartMapper;
import org.demointernetshop.repository.CartRepository;
import org.demointernetshop.repository.ProductRepository;
import org.demointernetshop.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CartService {

    private CartRepository cartRepository;
    private UserRepository userRepository;
    private CartMapper cartMapper;
    private ProductRepository productRepository;

    public CartDto getCart(Integer userId) {
        User foundUser = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User with id " + userId + " not found"));
        Cart cart = foundUser.getCart();

        return cartMapper.mapToCartDto(cart);
    }

    public CartDto updateCart(Integer userId, CartChangeRequestDto request) {
        User foundUser = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User with id " + userId + " not found"));

        Cart cart = foundUser.getCart();
        if (cart == null) {
            cart = new Cart();
            cart.setUser(foundUser);
        }

        Optional<CartItem> existingItem = cart.getCartItems().stream()
                .filter(item -> item.getProduct().getId().equals(request.getProduct_id()))
                .findFirst();

        if (existingItem.isPresent()) {
            existingItem.get().setQuantity(request.getCount());
        } else {
            Product product = productRepository.findById(request.getProduct_id()).orElseThrow(() -> new NotFoundException("Product with id " + request.getProduct_id() + " not found"));
            CartItem newItem = new CartItem();
            newItem.setProduct(product);
            newItem.setQuantity(request.getCount());
            newItem.setCart(cart);
            cart.getCartItems().add(newItem);
        }

        cartRepository.save(cart);

        return cartMapper.mapToCartDto(cart);
    }

}
