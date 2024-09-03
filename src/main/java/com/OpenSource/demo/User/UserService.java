//package com.OpenSource.demo.User;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.HashSet;
//import java.util.Optional;
//import java.util.Set;
//
//@Service
//public class UserService implements UserDetailsService {
//
//    private final UserRepo userRepository;
//    private final PasswordEncoder passwordEncoder;
//
//    public UserService(UserRepo userRepository, PasswordEncoder passwordEncoder) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    public User registerNewUser(User user) {
//        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
//            throw new IllegalArgumentException("User already exists");
//        }
//
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        Set<String> roles = new HashSet<>();
//        roles.add("ROLE_USER");
//        user.setRoles(roles);
//
//        return userRepository.save(user);
//    }
//
//    public Optional<User> getUserByUsername(String username) {
//        return userRepository.findByUsername(username);
//    }
//
//    public boolean checkPassword(String rawPassword, String encodedPassword) {
//        return passwordEncoder.matches(rawPassword, encodedPassword);
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<User> user = userRepository.findByUsername(username);
//        if (!user.isPresent()) {
//            throw new UsernameNotFoundException("User not found");
//        }
//        return new org.springframework.security.core.userdetails.User(user.get().getUsername(),
//                user.get().getPassword(),
//                new HashSet<>()); // Add proper authorities here
//    }
//}
