package example2.jpa.service;

import example2.jpa.payload.CreateUserRequest;
import example2.jpa.payload.UserDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public interface UserService {
    UserDto createUser(CreateUserRequest request);
    UserDto getUserById(Long id);
    void depositToAccount(Long accountNumber, BigDecimal amount);
    BigDecimal getTotalBalance(Long userId);
    // Add this method
}
