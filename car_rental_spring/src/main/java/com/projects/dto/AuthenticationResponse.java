package com.projects.dto;

import com.projects.enums.UserRole;
import lombok.Data;

@Data

public class AuthenticationResponse {
    private String jwt;
    private UserRole userRole;
    private Long userId;
}
