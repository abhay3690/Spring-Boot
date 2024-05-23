package com.code.fullstack_backend.controller;

import com.code.fullstack_backend.model.User;
import com.code.fullstack_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    User newUser(@RequestBody User newUSer){
        return userRepository.save(newUSer);
    }
    @GetMapping("/user")
    List<User> getAllUser(){
        return userRepository.findAll();
    }
}
