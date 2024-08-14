package example2.jpa.payload;

import lombok.Data;

import java.util.Set;

@Data
public class UserDto {
    private Long id;
    private String userName;
    private String email;
    private Long contactNumber;
    private String role;
    private Set<AccountDto> accounts;  // Change this to AccountDto
}
