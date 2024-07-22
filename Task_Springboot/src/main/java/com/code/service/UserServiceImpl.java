package com.code.service;

import com.code.dto.Userdto;
import com.code.repository.UserRepo;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepo userRepo;
    
    @Override
    public Userdto createUser(Userdto userdto, Integer Id) {

        return null;
    }

    @Override
    public Userdto updateUser(Userdto userdto, Integer Id) {
        return null;
    }

    @Override
    public Userdto deleteUser(Integer Id) {
        return null;
    }

    @Override
    public Userdto getProductById(Integer Id) {
        return null;
    }
}
