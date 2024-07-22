package com.code.service;

import com.code.dto.Userdto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    Userdto createUser(Userdto userdto);
    Userdto updateUser(Userdto userdto, Integer Id);
    Userdto deleteUser(Integer Id);
    Userdto getProductById(Integer Id);
}
