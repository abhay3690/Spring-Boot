package com.gaphql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gaphql.entities.Order;

public interface OrderRepo extends JpaRepository<Order, Integer>{

}
