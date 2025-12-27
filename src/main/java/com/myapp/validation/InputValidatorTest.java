package com.myapp.validation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InputValidatorTest {

    // --- Teste Funcționalitate (Req #2 - functionality) ---

    @Test
    public void testIsValidEmail_Success() {
        // Verificăm un email valid
        assertTrue(InputValidator.isValidEmail("alex@test.com"), "Email-ul corect ar trebui să fie valid");
    }

    @Test
    public void testIsValidEmail_Failure() {
        // Verificăm un email invalid
        assertFalse(InputValidator.isValidEmail("alextest.com"), "Email-ul fără @ ar trebui să fie invalid");
        assertFalse(InputValidator.isValidEmail(""), "Email-ul gol ar trebui să fie invalid");
        assertFalse(InputValidator.isValidEmail(null), "Null ar trebui să fie invalid");
    }

    @Test
    public void testIsNonNegativeDouble() {
        // Verificăm numere
        assertTrue(InputValidator.isNonNegativeDouble("10.5"), "10.5 este pozitiv");
        assertTrue(InputValidator.isNonNegativeDouble("0"), "0 este acceptat");
        assertFalse(InputValidator.isNonNegativeDouble("-5"), "Numerele negative trebuie respinse");
        assertFalse(InputValidator.isNonNegativeDouble("abc"), "Textul nu este număr");
    }
}