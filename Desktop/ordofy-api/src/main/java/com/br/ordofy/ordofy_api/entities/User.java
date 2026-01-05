package com.br.ordofy.ordofy_api.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.Objects;

@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    @Embedded
    private Password password;
    @Embedded
    private Email email;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT")
    private Instant birth;
    @Embedded
    private Phone phone;

    public User() {
    }

    public User(Instant birth, Email email, String password, Phone phone, String username) {
        this.birth = birth;
        this.email = email;
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
