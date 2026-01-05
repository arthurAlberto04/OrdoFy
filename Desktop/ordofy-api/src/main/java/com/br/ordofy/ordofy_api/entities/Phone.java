package com.br.ordofy.ordofy_api.entities;

import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class Phone {
    private String countryCode;
    private String areaCode;
    private String number;

    public Phone() {
    }

    public Phone(String areaCode, String countryCode, String number) {
        this.areaCode = areaCode;
        this.countryCode = countryCode;
        this.number = number;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return Objects.equals(getCountryCode(), phone.getCountryCode()) && Objects.equals(getAreaCode(), phone.getAreaCode()) && Objects.equals(getNumber(), phone.getNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCountryCode(), getAreaCode(), getNumber());
    }

    @Override
    public String toString() {
        return "Phone: +" + countryCode
            + " (" + areaCode
            + ") " + number;
    }
}
