package com.security.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.entity.UserInfo;

import com.security.repository.UserInfoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserInfoService implements UserDetailsService {
    private final UserInfoRepository userInfoRepository;


    @Autowired
    public UserInfoService(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

   
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> userInfo = userInfoRepository.findByName(username);
        return userInfo.map(UserInfoDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found" + username));
    }
//    public String addUser(UserInfo userInfo) {
//        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
//        userInfoRepository.save(userInfo);
//        return "User added successfully";
//    }
    public String addUser(UserInfo userInfo, PasswordEncoder passwordEncoder) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        userInfoRepository.save(userInfo);
        return "User added successfully";
    }

    public List<UserInfo> getAllUser() {
        return userInfoRepository.findAll();
    }

    public UserInfo getUser(Integer id) {
        return userInfoRepository.findById(id).orElse(null);
    }
}

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Service;
//
//import com.security.entity.UserInfo;
//import com.security.repository.UserInfoRepository;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class UserInfoService implements UserDetailsService {
//    @Autowired
//    private UserInfoRepository userInfoRepository;
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<UserInfo> userInfo = userInfoRepository.findByName(username);
//        return userInfo.map(UserInfoDetails::new)
//                .orElseThrow(()-> new UsernameNotFoundException("User not found"+username));
//    }
//    public String addUser(UserInfo userInfo){
//        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
//        userInfoRepository.save(userInfo);
//        return "User added successfully";
//    }
//    public List<UserInfo> getAllUser(){
//         return userInfoRepository.findAll();
//    }
//    public UserInfo getUser(Integer id){
//        return userInfoRepository.findById(id).get();
//    }
//}
