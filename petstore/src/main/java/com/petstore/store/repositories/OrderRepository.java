package com.petstore.store.repositories;

import com.petstore.store.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wichon on 2/5/17.
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query(value = "select * from orders o where price > :#{#price}", nativeQuery = true)
    List<Order> getOrdersAbove25(@Param("price") double price);
}

