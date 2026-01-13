package com.myapp.repository;

import com.myapp.model.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

/**
 * Repository interface for User entity.
 *
 * This interface provides database access operations for User objects.
 * Spring Data JPA automatically generates the implementation at runtime
 * based on method names and entity mapping.
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    // Spring automatically implements these methods based on their names
    // and the fields defined in the User entity.

    /**
     * Finds a user by email address.
     *
     * Used during the login process to retrieve user details.
     *
     * @param email the user's email address
     * @return an Optional containing the User if found, or empty if not
     */
    Optional<User> findByEmail(String email);

    /**
     * Checks whether a user with the given email already exists.
     *
     * Used during the registration process to prevent duplicate accounts.
     *
     * @param email the email address to check
     * @return true if a user with this email exists, false otherwise
     */
    boolean existsByEmail(String email);
}
