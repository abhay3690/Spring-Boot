package example2.jpa.service;

import example2.jpa.payload.CreateUserRequest;
import example2.jpa.payload.UserDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public interface UserService {
//    UserDetailsService userDetailsService();
    UserDto createUser(CreateUserRequest request);
    UserDto getUserById(Long id);
    void depositToAccount(Long accountNumber, BigDecimal amount);
    BigDecimal withdrawFromAccount(Long accountNumber, BigDecimal amount);
    UserDto getUserByAccountNumber(Long accountNumber);
    BigDecimal getAccountBalance(Long accountNumber);
    BigDecimal getAccountBalanceDetails(Long accountNumber);
    void transferFunds(Long fromAccountNumber, Long toAccountNumber, BigDecimal amount);
//    UserDto getAccountNoToAllDetails(Long accountNumber);
    // Add this method
}
