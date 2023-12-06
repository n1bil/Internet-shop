package org.demointernetshop.dto.orderDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.demointernetshop.entity.CartItem;
import org.demointernetshop.entity.User;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartResponseDto {

    private Integer id;
    private User user;
    private List<CartItem> cartItems;

}
