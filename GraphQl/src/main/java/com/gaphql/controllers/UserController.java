package com.gaphql.controllers;

import com.gaphql.entities.User;
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
public class UserController {
    @Autowired
    private UserService userService;
//      create user Api's
    @MutationMapping
    public User createUser(@Argument String name, @Argument String phone, @Argument String email, @Argument String password){
        User user =new User();
        user.setName(name);
        user.setEmail(email);
        user.setPhone(phone);
        user.setPassword(password);
        return userService.createUser(user);
    }
//      get users
    @QueryMapping
    public List<User> getAllUsers(){
        return userService.getAllUser();
    }
    //  get single user
    @QueryMapping
    public User getUser(@Argument int userId){
        return userService.getUser(userId);
    }
    @MutationMapping
    public boolean deleteUser(@Argument int userId){
        return userService.deleteUser(userId);
    }
//    @PutMapping
//    public User updateUser(int userId,User user){
//        return userService.updateUser(userId);
//    }
}
