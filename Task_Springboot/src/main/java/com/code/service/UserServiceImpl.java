package com.code.service;

import com.code.dto.Userdto;
import com.code.entities.User;
import com.code.repository.UserRepo;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final ModelMapper modelMapper;
    private final UserRepo userRepo;

    @Override
    public Userdto createUser(Userdto userdto ){
        User user = this.modelMapper.map(userdto,User.class);
        user.setId(userdto.getId());
        user.setName(userdto.getName());
        user.setNumber(userdto.getNumber());
        user.setAddress(userdto.getAddress());
        User save = this.userRepo.save(user);
        Userdto userdto1 = this.modelMapper.map(save, Userdto.class);
        return userdto1;
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
