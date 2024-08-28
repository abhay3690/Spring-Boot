package com.zosh.service;

import com.zosh.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {

    public User registerUser(User user);
    public User findUserById(Integer userId) throws Exception;
    public User findUserByEmail(String email);
    public User followUser(Integer userId1, Integer userId2) throws Exception;
    public User updateUser(User user, Integer userId) throws Exception;
    public List<User> searchUser(String query);
}
