package edu.aston.homework_microservice.service;

import edu.aston.homework_microservice.dto.CartDto;
import edu.aston.homework_microservice.mapper.CartMapper;
import edu.aston.homework_microservice.model.Cart;
import edu.aston.homework_microservice.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CartService {

    private final CartRepository repository;

    @Autowired
    public CartService(CartRepository repository) {
        this.repository = repository;
    }

    public UUID addCart(CartDto cartDto) {
        return repository.addCart(CartMapper.fromDto(cartDto));
    }

    public List<UUID> getCarts(CartDto cartDto) {
        repository.getCartsByUserId(cartDto.getUserId());
        return new ArrayList<>();
    }

    public void updateCart(CartDto cartDto) {
        repository.updateAmount(CartMapper.fromDto(cartDto));
    }

    public void deleteCarts(CartDto cartDto) {
        repository.deleteCartsByUserId(cartDto.getUserId());
    }

}
