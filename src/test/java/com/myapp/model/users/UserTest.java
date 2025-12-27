package com.myapp.model.users;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {

    // --- TEST 1: Verifică constructorul gol ---
    @Test
    public void testNoArgsConstructor() {
        User user = new User();

        // În noua versiune DB, câmpurile sunt null implicit, nu liste goale
        Assertions.assertNull(user.getName());
        Assertions.assertNull(user.getEmail());
    }

    // --- TEST 2: Verifică constructorul cu parametrii actuali ---
    @Test
    public void testAllArgsConstructor() {
        // Noul constructor are doar 4 parametri: Name, Email, Password, Role
        // (Listele au fost scoase temporar pentru compatibilitate DB)
        User user = new User("John Doe", "john@test.com", "pass123", "CLIENT");

        Assertions.assertEquals("John Doe", user.getName());
        Assertions.assertEquals("john@test.com", user.getEmail());
        Assertions.assertEquals("CLIENT", user.getRole());
    }

    // --- TEST 3: Verifică funcționalitatea Setterilor ---
    @Test
    public void testSetAndGetName() {
        User user = new User();
        user.setName("Alex");

        Assertions.assertEquals("Alex", user.getName());
    }

    // --- TEST 4: Verifică Rolul ---
    @Test
    public void testRoleFunctionality() {
        User user = new User();
        user.setRole("ADMIN");

        Assertions.assertEquals("ADMIN", user.getRole());
    }
}