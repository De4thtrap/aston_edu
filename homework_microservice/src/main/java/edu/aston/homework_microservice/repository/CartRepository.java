package edu.aston.homework_microservice.repository;

import edu.aston.homework_microservice.model.Cart;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends CrudRepository<Cart, String> {
  @Modifying
  @Query("UPDATE Cart c SET c.amount = :productAmount WHERE c.userId = :userId AND c.productId = :productId")
  void updateCartByUserIdAndProductId(String userId, String productId, int productAmount);

  Iterable<Cart> findAllByUserId(String userId);

  void deleteAllByUserId(String userId);
}
