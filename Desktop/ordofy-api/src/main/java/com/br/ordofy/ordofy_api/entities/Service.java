package com.br.ordofy.ordofy_api.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.*;

@Entity
@Table
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Duration duration;
    private BigDecimal price;

    @OneToMany(mappedBy = "id.service")
    private Set<ProfessionalService> professionals = new HashSet<>();

    public Service() {
    }

    public Service(Duration duration, String name, BigDecimal price) {
        this.duration = duration;
        this.name = name;
        this.price = price;
    }

    public int getId(){
        return id;
    }

    public Set<ProfessionalService> getProfessionals() {
        return professionals;
    }

    public BigDecimal getPrice(){
        return price;
    }

    public Duration getDuration() {
        return duration;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Service service = (Service) o;
        return Objects.equals(getName(), service.getName()) && Objects.equals(getDuration(), service.getDuration());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDuration());
    }
}
