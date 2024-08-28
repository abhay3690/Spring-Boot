package com.zosh.controller;

import com.zosh.model.User;
import com.zosh.repository.UserRepository;
import com.zosh.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    private final UserService userService;
    @PostMapping("/users")
    public User createUser(@RequestBody User user){
        User savedUser = userService.registerUser(user);
        return savedUser;
    }

    @GetMapping("/users")
    public List<User> getUser(){
        List<User> users = userRepository.findAll();
        return users;
    }

    @GetMapping("/users/{userid}")
    public User getUserById(@PathVariable("userid") Integer userId) throws Exception{
        User user = userService.findUserById(userId);
        return user;

    }

    @PutMapping("/users/{userId}")
    public User updateUser(@RequestBody User user, @PathVariable Integer userId) throws Exception {
        User updatedUser = userService.updateUser(user, userId);
        return updatedUser;
    }
    @PutMapping("/users/follow/{userId1}/{userId2}")
    public User followUserHandler(@PathVariable Integer userId1, @PathVariable Integer userId2) throws Exception {
        User user = userService.followUser(userId1,userId2);
        return user;
    }
    @GetMapping("/users/search")
    public List<User> searchUser(@RequestParam("query") String query){
        List<User> user = userService.searchUser(query);
        return user;
    }

   /* @DeleteMapping("users/{userId}")
    public String delteUser(@PathVariable("userId") Integer userId) throws Exception{
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            throw new Exception("User does not exist with id " + userId);
        }
        userRepository.delete(user.get());
        return "User delte successfully"+userId;
    }*/
}
