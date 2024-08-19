package example2.jpa.service.serviceimpl;

import example2.jpa.model.Account;
import example2.jpa.model.User;
import example2.jpa.payload.AccountDto;
import example2.jpa.payload.CreateUserRequest;
import example2.jpa.payload.UserDto;
import example2.jpa.repository.AccountRepository;
import example2.jpa.repository.UserRepository;
import example2.jpa.service.UserService;
//import org.springframework.security.core.userdetails.UserDetails;
import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AccountRepository accountRepository;

//
//    @Override
//    public UserDetailsService userDetailsService() {
//        return new UserDetailsService() {
//            @Override
//            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//                return userRepository.findFirstByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User Not found "));
//            }
//        };
//    }

    @Override
    public UserDto createUser(CreateUserRequest request) {
        // Create a new User entity from the request
        User user = new User();
        user.setUserName(request.getUserName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setContactNumber(user.getContactNumber());
        user.setUserRole(request.getUserRole());

        // Handle Accounts if provided in the CreateUserRequest
        if (request.getAccounts() != null && !request.getAccounts().isEmpty()) {
            Set<Account> accounts = request.getAccounts().stream()
                    .map(this::convertToAccountEntity)  // Convert each AccountDto to Account entity
                    .peek(account -> account.setUser(user))  // Set the user for each account
                    .collect(Collectors.toSet());
            user.setAccounts(accounts);  // Associate accounts with the user
        } else {
            user.setAccounts(new HashSet<>());  // Initialize an empty set of accounts
        }

        // Save the user to the database
        User savedUser = userRepository.save(user);

        // Convert the saved user entity to a UserDto
        return convertToUserDto(savedUser);
    }

    @Override
    public UserDto getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return convertToUserDto(user.get());
        } else {
            throw new RuntimeException("User not found"); // Handle not found case appropriately
        }
    }

    @Override
    public void depositToAccount(Long accountNumber, BigDecimal amount) {
        Optional<Account> accountOptional  = accountRepository.findByAccountNumber(accountNumber);
        if (accountOptional.isPresent()) {
            Account account = accountOptional.get();
            account.setBalance(account.getBalance().add(amount));
            accountRepository.save(account);
        } else {
            throw new RuntimeException("Account not found");
        }
    }


    @Override
    public BigDecimal getAccountBalanceDetails(Long accountNumber) {
        Optional<Account> accountOptional = accountRepository.findByAccountNumber(accountNumber);
        if (accountOptional.isPresent()) {
            return accountOptional.get().getBalance();
        } else {
            throw new RuntimeException("Account not found");
        }
    }

    @Override
    public UserDto getUserByAccountNumber(Long accountNumber) {
        Optional<Account> accountOptional = accountRepository.findByAccountNumber(accountNumber);
        if (accountOptional.isPresent()) {
            Account account = accountOptional.get();
            User user = account.getUser();
            return convertToUserDto(user);
        } else {
            throw new RuntimeException("Account not found");
        }
    }
    @Override
    public BigDecimal withdrawFromAccount(Long accountNumber, BigDecimal amount) {
        Optional<Account> accountOptional = accountRepository.findByAccountNumber(accountNumber);
        if (accountOptional.isPresent()) {
            Account account = accountOptional.get();

            if (account.getBalance().compareTo(amount) < 0) {
                throw new RuntimeException("Insufficient balance");
            }

            BigDecimal newBalance = account.getBalance().subtract(amount);
            account.setBalance(newBalance);
            accountRepository.save(account);

            return newBalance;
        } else {
            throw new RuntimeException("Account not found");
        }
    }

    private UserDto convertToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUserName(user.getUserName());
        userDto.setEmail(user.getEmail());
        userDto.setContactNumber(user.getContactNumber());
        userDto.setRole(user.getUserRole());

        // Convert Account entities to AccountDTOs
        Set<AccountDto> acc = user.getAccounts().stream()
                .map(this::convertToAccountDto)
                .collect(Collectors.toSet());

        userDto.setAccounts(acc);
        return userDto;
    }

    private AccountDto convertToAccountDto(Account account) {
        AccountDto accountDto = new AccountDto();
        accountDto.setId(account.getId());
        accountDto.setAccountNumber(account.getAccountNumber());
        accountDto.setBalance(account.getBalance());
        accountDto.setAccountType(account.getAccountType());
        return accountDto;
    }

    private Account convertToAccountEntity(AccountDto accountDto) {
        Account account = new Account();
        account.setAccountNumber(accountDto.getAccountNumber());
        account.setBalance(accountDto.getBalance());
        account.setAccountType(accountDto.getAccountType());
        return account;
    }
    @Override
    public BigDecimal getAccountBalance(Long accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber)
                .map(Account::getBalance)
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }
    @Override
    public void transferFunds(Long fromAccountNumber, Long toAccountNumber, BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Transfer amount must be positive.");
        }

        Optional<Account> fromAccountOptional = accountRepository.findByAccountNumber(fromAccountNumber);
        Optional<Account> toAccountOptional = accountRepository.findByAccountNumber(toAccountNumber);

        if (fromAccountOptional.isPresent() && toAccountOptional.isPresent()) {
            Account fromAccount = fromAccountOptional.get();
            Account toAccount = toAccountOptional.get();

            if (fromAccount.getBalance().compareTo(amount) >= 0) {
                // Deduct amount from the source account
                fromAccount.setBalance(fromAccount.getBalance().subtract(amount));

                // Add amount to the destination account
                toAccount.setBalance(toAccount.getBalance().add(amount));

                // Save the updated account balances
                accountRepository.save(fromAccount);
                accountRepository.save(toAccount);
            } else {
                throw new RuntimeException("Insufficient balance in the source account");
            }
        } else {
            throw new RuntimeException("One or both accounts not found");
        }
    }



}
