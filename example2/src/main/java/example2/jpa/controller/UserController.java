package example2.jpa.controller;

import example2.jpa.payload.*;
import example2.jpa.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody CreateUserRequest request) {
        try {
            UserDto userDto = userService.createUser(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(userDto);
        } catch (Exception e) {
            // Log the exception and return an appropriate error response
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        try {
            UserDto userDto = userService.getUserById(id);
            if (userDto == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            return ResponseEntity.ok(userDto);
        } catch (Exception e) {
            // Log the exception and return an appropriate error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/{accountNumber}/deposit")
    public ResponseEntity<Void> depositToAccount(
            @RequestParam Long accountNumber,
            @RequestParam BigDecimal amount) {
        try {
            userService.depositToAccount(accountNumber, amount);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            // Handle specific exceptions (e.g., account not found)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            // Log the exception and return an appropriate error response
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/{accountNumber}/total-balance")
    public ResponseEntity<AccountBalanceDetailsMesage> getAccountBalanceDetails(@PathVariable Long accountNumber) {
        try {
            BigDecimal totalBalance = userService.getAccountBalanceDetails(accountNumber);
            AccountBalanceDetailsMesage accountBalanceDetailsMesage = new AccountBalanceDetailsMesage("Your total account balance is below : ",totalBalance);
            return new ResponseEntity<>(accountBalanceDetailsMesage, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error fetching account balance for account number: {}", accountNumber, e);
            // riate error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new AccountBalanceDetailsMesage("An error occurred while retrieving account balance. Please try again later.", null));        }
    }

    @GetMapping("/account/{accountNumber}")
    public ResponseEntity<UserDto> getUserByAccountNumber(@PathVariable Long accountNumber) {
        UserDto userDto = userService.getUserByAccountNumber(accountNumber);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @PostMapping("/withdraw/{accountNumber}")
    public ResponseEntity<WithdrawResponseDto> withdrawFromAccount(@PathVariable Long accountNumber, @RequestParam BigDecimal amount) {
        BigDecimal updatedBalance = userService.withdrawFromAccount(accountNumber, amount);
        WithdrawResponseDto response = new WithdrawResponseDto("Withdraw Successful", updatedBalance);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/transfer")
    public ResponseEntity<?> transferFunds(
            @RequestParam Long fromAccountNumber,
            @RequestParam Long toAccountNumber,
            @RequestParam BigDecimal amount) {

        try {
            userService.transferFunds(fromAccountNumber, toAccountNumber, amount);

            // Retrieve the updated balances to include in the response
            BigDecimal fromAccountBalance = userService.getAccountBalance(fromAccountNumber);
            BigDecimal toAccountBalance = userService.getAccountBalance(toAccountNumber);

            TransferResponseDto response = new TransferResponseDto("Transfer Successful",fromAccountBalance, toAccountBalance);

            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

//    @PostMapping("/transferWithContactNumber")
//    public ResponseEntity<String> transferFundsWithContactNumber(
//            @RequestParam("fromContactNumber") Long fromContactNumber,
//            @RequestParam("toContactNumber") Long toContactNumber,
//            @RequestParam("amount") BigDecimal amount) {
//
//        try {
//            userService.transferFundsWithContactNumber(fromContactNumber, toContactNumber, amount);
//            return ResponseEntity.ok("Transfer successful");
//        } catch (IllegalArgumentException e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        } catch (RuntimeException e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
//        }
//    }
}


