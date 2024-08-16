package example2.jpa.payload;

import lombok.Data;

@Data
public class SignupRequest {

    private String email;

    private String userName;

    private String password;

}