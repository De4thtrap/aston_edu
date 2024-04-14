package edu.aston.homework_microservice.controller;

import edu.aston.homework_microservice.dto.CartDto;
import edu.aston.homework_microservice.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartService service;

    @Autowired
    public CartController(CartService service) {
        this.service = service;
    }

    @PostMapping("/{userId}")
    ResponseEntity<UUID> addCart(@PathVariable UUID userId) {
        CartDto dto = new CartDto();
        return ResponseEntity.ok().body(service.addCart(dto));
    }


    @GetMapping("/{userId}")
    ResponseEntity<List<UUID>> getCart(@PathVariable UUID userId) {
        CartDto dto = new CartDto();
        return ResponseEntity.ok().body(service.getCarts(dto));
    }

    @PutMapping("/{userId}")
    ResponseEntity<String> updateCart(@PathVariable UUID userId) {
        CartDto dto = new CartDto();
        service.updateCart(dto);
        return ResponseEntity.ok().body("");
    }

    @DeleteMapping("/{userId}")
    ResponseEntity<String> deleteCart(@PathVariable UUID userId) {
        CartDto dto = new CartDto();
        service.deleteCarts(dto);
        return ResponseEntity.ok().body("");
    }
}
