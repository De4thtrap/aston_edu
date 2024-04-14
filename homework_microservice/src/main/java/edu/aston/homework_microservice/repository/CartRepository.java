package edu.aston.homework_microservice.repository;

import edu.aston.homework_microservice.model.Cart;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Repository
public class CartRepository {

    public CartRepository() {}

    public UUID addCart(Cart cart) {
        return UUID.randomUUID();
    }

    public List<Cart> getCartsByUserId(UUID userId) {
        return Arrays.asList(new Cart());
    }

    public void updateAmount(Cart cart) {}

    public void deleteCartsByUserId(UUID userId) {}

}
