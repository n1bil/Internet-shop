package org.demointernetshop.dto.orderDto;

import org.demointernetshop.entity.CartItem;
import org.demointernetshop.entity.User;

import java.util.List;

public class CartResponseDto {

    private User user;
    private List<CartItem> cartItems;

}
