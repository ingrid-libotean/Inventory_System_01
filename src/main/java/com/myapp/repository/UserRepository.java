package com.myapp.repository;

import com.myapp.model.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    // Spring implementează automat aceste metode bazat pe numele lor:

    // 1. Caută user după email (pentru Login)
    Optional<User> findByEmail(String email);

    // 2. Verifică dacă există deja (pentru Register)
    boolean existsByEmail(String email);
}