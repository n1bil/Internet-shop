package org.demointernetshop.mapper;

import org.demointernetshop.dto.cart.CartDto;
import org.demointernetshop.dto.product.ProductShortInfoDto;
import org.demointernetshop.entity.Cart;
import org.demointernetshop.entity.CartItem;

import java.util.List;
import java.util.stream.Collectors;

public class CartMapper {

    public CartDto mapToCartDto(Cart cart) {
        return CartDto.builder()
                .id(cart.getId())
                .userId(cart.getUser().getId())
                .products(mapToProductShortInfoDtoList(cart.getCartItems()))
                .build();
    }

    public List<ProductShortInfoDto> mapToProductShortInfoDtoList(List<CartItem> cartItems) {
        return cartItems.stream()
                .map(cartItem -> new ProductShortInfoDto(
                        cartItem.getProduct().getId(),
                        cartItem.getProduct().getName(),
                        cartItem.getProduct().getProductInfo().getPrice(),
                        cartItem.getQuantity()
                ))
                .collect(Collectors.toList());
    }

}
