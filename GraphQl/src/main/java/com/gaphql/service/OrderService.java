package com.gaphql.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaphql.entities.Order;
import com.gaphql.entities.User;
import com.gaphql.helper.ExceptionHelper;
import com.gaphql.repositories.OrderRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {
	@Autowired
	private OrderRepo orderRepo;
	public Order createOrder(Order order) {
		return orderRepo.save(order);
	} 
	public List<Order> getAllOrder(){
		return orderRepo.findAll();
	}
	public Order getOrder(Integer orderId) {
		Order order = orderRepo.findById(orderId).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
		return order;
	}
	public boolean deleteOrder(int orderId) {
		Order order = orderRepo.findById(orderId).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
		orderRepo.delete(order);
		return true;
	}
	public Order updateOrder(int orderId, Order order) {
		Order order2 = orderRepo.findById(orderId).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
		order2.setOrderDetails(order.getOrderDetails());
		order2.setAddress(order.getAddress());
		order2.setPrice(order.getPrice());
		Order save = orderRepo.save(order2);
		return save;
	}

}
