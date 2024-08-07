//package com.projects.service.auth;
//
//import com.projects.dto.SignupRequest;
//import com.projects.dto.UserDto;
//import com.projects.entity.User;
//import com.projects.enums.UserRole;
//import com.projects.repository.UserRepository;
//import jakarta.annotation.PostConstruct;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class AuthServiceImpl implements AuthService {
//    private final UserRepository userRepository;
//    @PostConstruct
//    public void createAdminAccount(){
//        User adminAccount = userRepository.findByUserRole(UserRole.ADMIN);
//        if (adminAccount == null){
//            User newAdminAccount = new User();
//            newAdminAccount.setName("Admin");
//            newAdminAccount.setEmail("admin@test.com");
//            newAdminAccount.setPassword(new BCryptPasswordEncoder().encode(" "));
//            newAdminAccount.setUserRole(UserRole.ADMIN);
//            userRepository.save(newAdminAccount);
//            System.out.println("Admin Account created Successfully");
//        }
//    }
//
//    @Override
//    public UserDto createCustomer(SignupRequest signupRequest) {
//        User user = new User();
//        user.setName(signupRequest.getName());
//        user.setEmail(signupRequest.getEmail());
//        user.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));
//        user.setUserRole(UserRole.CUTOMERS);
//        User createdUser = userRepository.save(user);
//        UserDto userDto = new UserDto();
//        userDto.setId(createdUser.getId());
//        return userDto;
//    }
//
//    @Override
//    public boolean hasCustomerWithEmail(String email) {
//
//        return userRepository.findFirstByEmail(email).isPresent();
//    }
//}
