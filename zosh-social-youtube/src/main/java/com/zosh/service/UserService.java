package com.zosh.service;

import com.zosh.exception.UserException;
import com.zosh.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {

    public User registerUser(User user);
    public User findUserById(Integer userId) throws UserException;
    public User findUserByEmail(String email);
    public User followUser(Integer userId1, Integer userId2) throws UserException;
    public User updateUser(User user, Integer userId) throws UserException;
    public List<User> searchUser(String query);
    public User findUserByJwt(String jwt);
}
