package com.gaphql.controllers;

import com.gaphql.entities.Order;
import com.gaphql.entities.User;
import com.gaphql.service.OrderService;
import com.gaphql.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrderController {
    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;
    @MutationMapping
    public Order createOrder(
       @Argument String orderDetails,
       @Argument String address,
       @Argument int price,
       @Argument int userId){
        User user = userService.getUser(userId);
        System.out.println(orderDetails);
        Order order = new Order();
        order.setOrderDetails(orderDetails);
        order.setAddress(address);
        order.setPrice(price);
        order.setUser(user);
        Order order1 = orderService.createOrder(order);
        return order1;
    }
    @QueryMapping
    public List<Order> getAllOrder(){
        return orderService.getAllOrder();
    }
    @QueryMapping
    public Order getOrders(@Argument int orderId){
        return orderService.getOrder(orderId);
    }
    @MutationMapping
    public Boolean deleteOrder(int orderId){
        return orderService.deleteOrder(orderId);
    }

}
