package com.myapp.validation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the InputValidator class.
 *
 * This test class verifies that input validation methods behave correctly
 * for both valid and invalid inputs.
 */
public class InputValidatorTest {

    // --- Functionality Tests (Requirement #2 – functionality) ---
    // These tests ensure that the validation methods work as expected.

    @Test
    public void testIsValidEmail_Success() {
        // Test a correctly formatted email address
        // The method should return true for valid input
        assertTrue(
                InputValidator.isValidEmail("alex@test.com"),
                "A correctly formatted email should be considered valid"
        );
    }

    @Test
    public void testIsValidEmail_Failure() {
        // Test an email missing the '@' symbol
        // The method should return false for invalid formats
        assertFalse(
                InputValidator.isValidEmail("alextest.com"),
                "An email without '@' should be considered invalid"
        );

        // Test an empty string
        // Empty input should not be accepted as a valid email
        assertFalse(
                InputValidator.isValidEmail(""),
                "An empty email string should be considered invalid"
        );

        // Test a null value
        // The method should safely handle null input and return false
        assertFalse(
                InputValidator.isValidEmail(null),
                "A null email value should be considered invalid"
        );
    }

    @Test
    public void testIsNonNegativeDouble() {
        // Test a valid positive decimal number
        // The method should return true for non-negative numeric values
        assertTrue(
                InputValidator.isNonNegativeDouble("10.5"),
                "10.5 is a positive number and should be accepted"
        );

        // Test zero
        // Zero is considered non-negative and should be accepted
        assertTrue(
                InputValidator.isNonNegativeDouble("0"),
                "0 is non-negative and should be accepted"
        );

        // Test a negative number
        // Negative values should be rejected
        assertFalse(
                InputValidator.isNonNegativeDouble("-5"),
                "Negative numbers should be rejected"
        );

        // Test a non-numeric string
        // Text input that cannot be parsed as a number should be rejected
        assertFalse(
                InputValidator.isNonNegativeDouble("abc"),
                "Non-numeric text should not be accepted as a number"
        );
    }
}
