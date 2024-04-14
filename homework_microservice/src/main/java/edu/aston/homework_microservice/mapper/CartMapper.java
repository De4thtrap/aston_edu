package edu.aston.homework_microservice.mapper;

import edu.aston.homework_microservice.dto.CartDto;
import edu.aston.homework_microservice.model.Cart;

public class CartMapper {
    public static CartDto toDto(Cart cart) {
        return new CartDto();
    }

    public static Cart fromDto(CartDto dto) {
        return new Cart();
    }
}
