package com.code.service;

import com.code.dto.UserDto;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    UserDto createUser(UserDto userDTO);

    UserDto updateUser(Long id, UserDto userDTO);

    List<UserDto> getAllUsers();

    UserDto getUserById(Long id);

    void deleteUser(Long id);
}
