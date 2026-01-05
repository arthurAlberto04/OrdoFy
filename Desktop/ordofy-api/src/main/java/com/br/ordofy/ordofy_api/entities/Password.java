package com.br.ordofy.ordofy_api.entities;

import jakarta.persistence.Embeddable;

import java.util.Objects;
import java.util.regex.Pattern;

@Embeddable
public class Password {
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&]).{8,}$");

    private final String hashedValue;

    private Password(String hashedValue) {
        this.hashedValue = hashedValue;
    }

    public static Password create(String rawPassword) {
        if (rawPassword == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        if (!PASSWORD_PATTERN.matcher(rawPassword).matches()) {
            throw new IllegalArgumentException(
                    "Password must have at least 8 characters, one uppercase, one lowercase, one number and one special character"
            );
        }

        String hash = PasswordHasher.hash(rawPassword);
        return new Password(hash);
    }

    public boolean matches(String rawPassword) {
        return PasswordHasher.verify(rawPassword, this.hashedValue);
    }

    public String getValue() {
        return hashedValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Password)) return false;
        Password password = (Password) o;
        return Objects.equals(hashedValue, password.hashedValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hashedValue);
    }
}
