package com.zosh.controller;

import com.zosh.exception.UserException;
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


    @GetMapping("/api/users")
    public List<User> getUser(){
        List<User> users = userRepository.findAll();
        return users;
    }

    @GetMapping("/api/users/{userid}")
    public User getUserById(@PathVariable("userid") Integer userId) throws UserException{
        User user = userService.findUserById(userId);
        return user;

    }

    @PutMapping("/api/users")
    public User updateUser(@RequestHeader("Authorization") String jwt, @RequestBody User user) throws UserException {
        User reqUser = userService.findUserByJwt(jwt);
        User updatedUser = userService.updateUser(user, reqUser.getId());
        return updatedUser;
    }
    @PutMapping("/api/users/follow/{userId2}")
    public User followUserHandler(@RequestHeader("Authorization") String jwt, @PathVariable Integer userId2) throws UserException {
        User reqUser = userService.findUserByJwt(jwt);
        User user = userService.followUser(reqUser.getId(),userId2);
        return user;
    }
    @GetMapping("/api/users/search")
    public List<User> searchUser(@RequestParam("query") String query){
        List<User> user = userService.searchUser(query);
        return user;
    }
@GetMapping("/api/users/profile")
public User getUserFromToken(@RequestHeader("Authorization") String jwt) {

    User user = userService.findUserByJwt(jwt);
    user.setPassword(null);
    // Add your logic to retrieve the user using the JWT token
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
