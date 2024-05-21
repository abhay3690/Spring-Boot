package net.abhay.blog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.abhay.controllers.AuthenticationRequest;
import net.abhay.controllers.AuthenticationResponse;
import net.abhay.exceptions.ApiException;
import net.abhay.repositories.UserRepo;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    @Autowired
    private final UserRepo userRepository;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private final JwtService jwtService;

    @Autowired
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        try {
            authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
            var user = userRepository.findByEmail(request.getEmail()).orElseThrow();
            var jwtToken = jwtService.generateToken(user);
            return AuthenticationResponse.builder().token(jwtToken).build();
        } catch (BadCredentialsException e) {
            System.out.println("Invalid Details!");
            throw new ApiException("Invalid Username And Password");
        }
    }
}
