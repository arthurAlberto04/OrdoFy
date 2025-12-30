package com.br.ordofy.ordofy_api.entities;

import java.time.Instant;
import java.util.Objects;

public class User {
    private Integer id;
    private String username;
    private Password password;
    private Email email;
    private Instant birth;
    private Phone phone;

    public User() {
    }

    public User(Instant birth, Email email, Integer id, String password, Phone phone, String username) {
        this.birth = birth;
        this.email = email;
        this.id = id;
        this.password = Password.create(password);
        this.phone = phone;
        this.username = username;
    }

    public Instant getBirth() {
        return birth;
    }

    public Email getEmail() {
        return email;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public Phone getPhone() {
        return phone;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

}
