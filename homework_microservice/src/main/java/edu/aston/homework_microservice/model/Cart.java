package edu.aston.homework_microservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cart {
    private UUID cartId;

    private UUID userId;

    private UUID productId;

    private int amount;
}
