package com.OpenSource.demo.Auth;

import com.OpenSource.demo.Auth.AuthenticationRequest;
import com.OpenSource.demo.Auth.AuthenticationResponse;
import com.OpenSource.demo.Auth.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class UserController {
    private final AuthenticationService service;
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> registerUser(@RequestBody RegisterRequest request) {
            return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> registerUser(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(service.authenticate(request));
    }

}
//    private final UserService userService;
//
//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @PostMapping("/register")
//    public ResponseEntity<String> registerUser(@RequestBody User user) {
//        try {
//            userService.registerNewUser(user);
//            return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
//        } catch (IllegalArgumentException e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
//        }
//    }
//
//
//    @PostMapping("/login")
//    public ResponseEntity<String> loginUser(@RequestBody User user) {
//        Optional<User> foundUser = userService.getUserByUsername(user.getUsername());
//
//        if (foundUser.isPresent() && userService.checkPassword(user.getPassword(), foundUser.get().getPassword())) {
//            return ResponseEntity.ok("Login successful");
//        } else {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
//        }
//    }

//
//    CREATE TABLE IF NOT EXISTS users (
//        id BIGINT AUTO_INCREMENT PRIMARY KEY,
//        username VARCHAR(50) NOT NULL UNIQUE,
//    password VARCHAR(255) NOT NULL,
//    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
//);
