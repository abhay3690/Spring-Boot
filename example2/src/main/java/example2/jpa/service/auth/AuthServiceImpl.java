//package example2.jpa.service.auth;
//
//import example2.jpa.enums.UserRole;
//import example2.jpa.model.User;
//import example2.jpa.payload.SignupRequest;
//import example2.jpa.payload.UserDto;
//import example2.jpa.repository.UserRepository;
//import jakarta.annotation.PostConstruct;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class AuthServiceImpl implements AuthService {
//    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder; // Injected PasswordEncoder bean
//
//    @PostConstruct
//    public void createAdminAccount() {
//        User adminAccount = userRepository.findByUserRole(UserRole.ADMIN.name());
//        if (adminAccount == null) {
//            User newAdminAccount = new User();
//            newAdminAccount.setUserName("Admin");
//            newAdminAccount.setEmail("admin@test.com");
//            newAdminAccount.setPassword(passwordEncoder.encode("Admin@123")); // Removed extra space
//            newAdminAccount.setUserRole(UserRole.ADMIN.name());
//            userRepository.save(newAdminAccount);
//            System.out.println("Admin Account created Successfully");
//        }
//    }
//
//    @Override
//    public UserDto createCustomer(SignupRequest signupRequest) {
//        User user = new User();
//        user.setUserName(signupRequest.getUserName());
//        user.setEmail(signupRequest.getEmail());
//        user.setPassword(passwordEncoder.encode(signupRequest.getPassword())); // Use injected encoder
//
//        user.setUserRole(UserRole.CUSTOMER.name());
//        User createdUser = userRepository.save(user);
//        UserDto userDto = new UserDto();
//        userDto.setId(createdUser.getId());
//        return userDto;
//    }
//
//    @Override
//    public boolean hasCustomerWithEmail(String email) {
//        return userRepository.findFirstByEmail(email).isPresent();
//    }
//}
