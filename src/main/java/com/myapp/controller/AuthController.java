package com.myapp.controller;

import com.myapp.model.users.User;
import com.myapp.repository.UserRepository;
import com.myapp.validation.InputValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*") // Allows your HTML frontend to talk to this backend
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    // 1. REGISTER Endpoint
    @PostMapping("/register")
    public String registerUser(@RequestBody User newUser) {
        // --- VALIDARE (Req #9) ---

        // 1. Verifică dacă câmpurile sunt goale
        if (!InputValidator.isNonEmptyString(newUser.getName())) {
            return "Error: Name cannot be empty!";
        }

        // 2. Verifică formatul email-ului
        if (!InputValidator.isValidEmail(newUser.getEmail())) {
            return "Error: Invalid email format!";
        }

        // 3. Verifică lungimea parolei (poți adăuga o metodă în InputValidator pt asta)
        if (!InputValidator.isNonEmptyString(newUser.getPassword()) || newUser.getPassword().length() < 4) {
            return "Error: Password must be at least 4 characters!";
        }

        // --- END VALIDARE ---

        if (userRepository.existsByEmail(newUser.getEmail())) {
            return "Error: Email already taken!";
        }

        userRepository.save(newUser);
        return "Success: User registered!";
    }

    // 2. LOGIN Endpoint
    @PostMapping("/login")
    public String loginUser(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        String password = credentials.get("password");

        Optional<User> userOpt = userRepository.findByEmail(email);

        if (userOpt.isPresent()) {
            User user = userOpt.get();
            if (user.getPassword().equals(password)) {
                // Here we would generate OTP (Next Step)
                return "Success: Login valid. OTP sent (Simulated). Role: " + user.getRole();
            }
        }
        return "Error: Invalid credentials";
    }
}