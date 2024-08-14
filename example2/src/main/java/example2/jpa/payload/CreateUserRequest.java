package example2.jpa.payload;

import lombok.Data;

import java.util.Set;

@Data
public class CreateUserRequest {
    private String userName;
    private String contactNumber;
    private String email;
    private String password;
    private String role;
    private Set<AccountDto> accounts; // Ensure this field exists
}

