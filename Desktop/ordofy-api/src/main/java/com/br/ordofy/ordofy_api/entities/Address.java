package com.br.ordofy.ordofy_api.entities;

public class Address {
    private String zipCode;
    private String street;
    private Integer number;
    private String city;
    private String country;
    private String state;
    private String neighborhood;
    private String complement;

    public Address() {
    }

    public Address(String city, String complement, String country, String neighborhood, Integer number, String state, String zipCode, String street) {
        this.city = city;
        this.complement = complement;
        this.country = country;
        this.neighborhood = neighborhood;
        this.number = number;
        this.state = state;
        this.zipCode = zipCode;
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getCountry() {
        return country;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }
}
