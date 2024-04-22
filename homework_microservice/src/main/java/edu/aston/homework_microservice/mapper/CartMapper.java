package edu.aston.homework_microservice.mapper;

import edu.aston.homework_microservice.dto.CartDto;
import edu.aston.homework_microservice.dto.RequestDto;
import edu.aston.homework_microservice.model.Cart;
import java.util.UUID;

public class CartMapper {
    public static CartDto toDto(Cart cart) {
        return new CartDto(
            cart.getCartId(),
            cart.getProductId(),
            cart.getAmount());
    }

    public static Cart fromDto(RequestDto dto) {
        return new Cart(
            UUID.randomUUID().toString(),
            dto.getUserId(),
            dto.getProductId(),
            dto.getProductAmount());
    }
}
