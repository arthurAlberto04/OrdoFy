package com.br.ordofy.ordofy_api.entities;

import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class Cnpj {
    private String value;

    public Cnpj(String value) {
        if (!isValid(value)) {
            throw new IllegalArgumentException("Invalid CNPJ");
        }
        this.value = normalize(value);
    }

    public String getValue() {
        return value;
    }

    private String normalize(String cnpj) {
        return cnpj.replaceAll("\\D", "");
    }

    public String formatted() {
        return value.replaceFirst(
                "(\\d{2})(\\d{3})(\\d{3})(\\d{4})(\\d{2})",
                "$1.$2.$3/$4-$5"
        );
    }

    private boolean isValid(String cnpj) {
        String digits = normalize(cnpj);

        if (digits.length() != 14) return false;
        if (digits.matches("(\\d)\\1{13}")) return false;

        return validateDigit(digits, 12) && validateDigit(digits, 13);
    }

    private boolean validateDigit(String cnpj, int pos) {
        int[] weights = pos == 12
                ? new int[]{5,4,3,2,9,8,7,6,5,4,3,2}
                : new int[]{6,5,4,3,2,9,8,7,6,5,4,3,2};

        int sum = 0;
        for (int i = 0; i < weights.length; i++) {
            sum += Character.getNumericValue(cnpj.charAt(i)) * weights[i];
        }

        int digit = sum % 11 < 2 ? 0 : 11 - (sum % 11);
        return digit == Character.getNumericValue(cnpj.charAt(pos));
    }

    @Override
    public String toString() {
        return formatted();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cnpj cnpj = (Cnpj) o;
        return Objects.equals(getValue(), cnpj.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getValue());
    }
}

