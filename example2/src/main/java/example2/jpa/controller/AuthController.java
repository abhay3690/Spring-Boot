//package example2.jpa.controller;
//
//import example2.jpa.model.User;
//import example2.jpa.payload.AuthenticationRequest;
//import example2.jpa.payload.AuthenticationResponse;
//import example2.jpa.payload.SignupRequest;
//import example2.jpa.payload.UserDto;
//import example2.jpa.repository.UserRepository;
//import example2.jpa.service.UserService;
//import example2.jpa.service.auth.AuthService;
//import example2.jpa.util.JWTUtils;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.DisabledException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/auth")
//@RequiredArgsConstructor
//public class AuthController {
//    private final AuthService authService;
//    private final AuthenticationManager authenticationManager;
//    private final UserService userService;
//    private final JWTUtils jwtUtils;
//    private final UserRepository userRepository;
//
//    @PostMapping("/signup")
//    public ResponseEntity<?> signupCustomer(@RequestBody SignupRequest signupRequest) {
//        if (authService.hasCustomerWithEmail(signupRequest.getEmail()))
//            return new ResponseEntity<>("Customer Already exists with this email", HttpStatus.NOT_ACCEPTABLE);
//
//        UserDto createdCustomerDto = authService.createCustomer(signupRequest);
//        if (createdCustomerDto == null)
//            return new ResponseEntity<>("Customer not created, come again later", HttpStatus.BAD_REQUEST);
//
//        return new ResponseEntity<>(createdCustomerDto, HttpStatus.CREATED);
//    }
//
//    @PostMapping("/login")
//    public AuthenticationResponse createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws
//            BadCredentialsException, DisabledException, UsernameNotFoundException {
//        try {
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
//                    authenticationRequest.getEmail(), authenticationRequest.getPassword()));
//        } catch (BadCredentialsException e) {
//            throw new BadCredentialsException("Incorrect username or password.");
//        }
//
//        final UserDetails userDetails = userService.userDetailsService().loadUserByUsername(authenticationRequest.getEmail());
//        Optional<User> optionalUser = userRepository.findFirstByEmail(userDetails.getUsername());
//        final String jwt = jwtUtils.generateToken(userDetails);
//
//        AuthenticationResponse authenticationResponse = new AuthenticationResponse();
//        if (optionalUser.isPresent()) {
//            authenticationResponse.setJwt(jwt);
//            authenticationResponse.setUserId(optionalUser.get().getId());
//        }
//
//        return authenticationResponse;
//    }
//}
