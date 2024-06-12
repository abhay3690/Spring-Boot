package com.security;

import lombok.Data;

@Data
public class AuthenticationRequest {
    private String email;
    private String password;
}





//package com.security;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//public class AuthenticationRequest {
//
//	private String email;
//
//	private String password;
//}