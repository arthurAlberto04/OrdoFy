package com.br.ordofy.ordofy_api.entities;

import java.util.Objects;

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

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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
}
