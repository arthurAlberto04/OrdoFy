package com.br.ordofy.ordofy_api.entities;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table
public class Business {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Embedded
    private Address address;
    @Embedded
    private Phone phone;
    @Embedded
    private LegalEntity legalEntity;

    @OneToMany(mappedBy = "business")
    private List<Professional> professionals = new ArrayList<>();

    public Business() {
    }

    public Business(Address address, LegalEntity cnpj, String name, Phone phone) {
        this.address = address;
        this.legalEntity = cnpj;
        this.name = name;
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }
    
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Phone getPhone() {
        return phone;
    }

    public List<Professional> getProfessionals() {
        return professionals;
    }

    public void addProfssional(Professional p){
        professionals.add(p);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Business business = (Business) o;
        return Objects.equals(getId(), business.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
