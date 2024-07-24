package com.code.service;


import com.code.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{


    @Override
    public UserDto createUser(UserDto userDTO) {
        return null;
    }

    @Override
    public UserDto updateUser(Long id, UserDto userDTO) {
        return null;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return List.of();
    }

    @Override
    public UserDto getUserById(Long id) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {

    }
}


