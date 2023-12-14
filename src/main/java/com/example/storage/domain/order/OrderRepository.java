package com.example.storage.domain.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query("select o from Order o where o.customerUser.id = ?1")
    List<Order> findByCustomerUserId(Integer id);

}