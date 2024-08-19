package example2.jpa.payload;


import lombok.Data;

import java.util.Set;

@Data
public class CreateUserRequest {
    private String userName;
    private Long contactNumber;
    private String email;
    private String password;
    private String userRole;
    private Set<AccountDto> accounts; // Ensure this field exists
}

