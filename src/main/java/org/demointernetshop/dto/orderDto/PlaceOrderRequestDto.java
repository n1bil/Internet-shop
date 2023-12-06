package org.demointernetshop.dto.orderDto;

import org.demointernetshop.entity.CartItem;

import java.util.List;

public class PlaceOrderRequestDto {

    private Integer user_id;
    private List<CartItem> cartItems;

}
