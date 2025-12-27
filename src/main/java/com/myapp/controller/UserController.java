package com.myapp.controller;

import com.myapp.model.users.User;
import com.myapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Doar ADMIN-ul ar trebui să apeleze asta
    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Funcție de ștergere a unui user (Admin only)
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return "User deleted";
        }
        return "User not found";
    }

    // Funcție pentru a schimba rolul (Promote to Admin)
    @PutMapping("/promote/{id}")
    public User promoteToAdmin(@PathVariable int id) {
        return userRepository.findById(id).map(user -> {
            user.setRole("ADMIN");
            return userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }
}