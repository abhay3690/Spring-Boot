package com.projects.entity;

import com.projects.enums.UserRole;
import jakarta.persistence.*;
import lombok.Data;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
@Data
@Entity
@Table(name = "users")
public class User{
//public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private UserRole userRole;

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return List.of(new SimpleGrantedAuthority(userRole.name()));
//    }
//
//    @Override
//    public String getUsername() {
//        return email;
//    }
}
