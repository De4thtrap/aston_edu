package edu.aston.homework_microservice.service;

import edu.aston.homework_microservice.dto.CartDto;
import edu.aston.homework_microservice.dto.RequestDto;
import edu.aston.homework_microservice.dto.ResponseDto;
import edu.aston.homework_microservice.mapper.CartMapper;
import edu.aston.homework_microservice.model.Cart;
import edu.aston.homework_microservice.repository.CartRepository;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    private final CartRepository repository;

    @Autowired
    public CartService(CartRepository repository) {
        this.repository = repository;
    }

    public void addCart(RequestDto requestDto) {
        repository.save(CartMapper.fromDto(requestDto));
    }

    public ResponseDto  getCarts(RequestDto requestDto) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setUserId(requestDto.getUserId());

        Iterator<Cart> cartIterator =
            repository.findAllByUserId(requestDto.getUserId()).iterator();
        List<CartDto> carts = new ArrayList<>();
        while (cartIterator.hasNext()) {
            carts.add(CartMapper.toDto(cartIterator.next()));
        }
        responseDto.setCarts(carts);
        return responseDto;
    }

    @Transactional
    public void updateCart(RequestDto requestDto) {
        repository.updateCartByUserIdAndProductId(
            requestDto.getUserId(), requestDto.getProductId(), requestDto.getProductAmount());
    }

    @Transactional
    public void deleteCarts(RequestDto requestDto) {
        repository.deleteAllByUserId(requestDto.getUserId());
    }

}
