package edu.aston.homework_microservice.controller;

import edu.aston.homework_microservice.dto.RequestDto;
import edu.aston.homework_microservice.dto.ResponseDto;
import edu.aston.homework_microservice.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartService service;

    @Autowired
    public CartController(CartService service) {
        this.service = service;
    }

    @PostMapping("/add")
    ResponseEntity<HttpStatus> addCart(@RequestBody RequestDto dto) {
        service.addCart(dto);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }

    @GetMapping("/get")
    ResponseEntity<ResponseDto> getCart(@RequestBody RequestDto dto) {
        return ResponseEntity.ok().body(service.getCarts(dto));
    }

    @PatchMapping("/update")
    ResponseEntity<HttpStatus> updateCart(@RequestBody RequestDto dto) {
        service.updateCart(dto);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    ResponseEntity<HttpStatus> deleteCart(@RequestBody RequestDto dto) {
        service.deleteCarts(dto);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }
}
