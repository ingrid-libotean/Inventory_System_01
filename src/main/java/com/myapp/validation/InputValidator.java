package com.myapp.validation;  // <- you can choose a util / helper package

import java.util.regex.Pattern;

public class InputValidator {

    // Regex for a reasonable email format
    private static final String EMAIL_REGEX =
            "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
                    "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    // Prevent instantiation
    private InputValidator() { }

    /** Checks if the given email looks valid. */
    public static boolean isValidEmail(String email) {
        if (email == null) return false;
        return EMAIL_PATTERN.matcher(email).matches();
    }

    /** Checks if the string is non-null and contains non-whitespace characters. */
    public static boolean isNonEmptyString(String s) {
        return s != null && !s.trim().isEmpty();
    }

    /** Checks if the string represents a non-negative double (>= 0). */
    public static boolean isNonNegativeDouble(String s) {
        if (s == null) return false;
        try {
            double v = Double.parseDouble(s.trim());
            return v >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /** Checks if the string represents a positive double (> 0). */
    public static boolean isPositiveDouble(String s) {
        if (s == null) return false;
        try {
            double v = Double.parseDouble(s.trim());
            return v > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /** Checks if the string represents an integer (without decimal). */
    public static boolean isInteger(String s) {
        if (s == null) return false;
        try {
            Integer.parseInt(s.trim());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
