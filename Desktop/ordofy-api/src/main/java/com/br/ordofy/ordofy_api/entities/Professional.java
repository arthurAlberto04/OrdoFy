package com.br.ordofy.ordofy_api.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Professional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "business_id")
    private Business business;

    @OneToMany(mappedBy = "id.professional")
    private Set<ProfessionalService> serviceList = new HashSet<>();

    @OneToMany(mappedBy = "professional")
    private Set<Schedule> appointments = new HashSet<>();

    @OneToMany(mappedBy = "professional")
    private Set<ProfessionalWorkingHours> workingHours = new HashSet<>();

    public Professional() {
    }

    public Set<ProfessionalWorkingHours> getWorkingHours() {
        return workingHours;
    }

    public Integer getId(){
        return id;
    }

    public Professional(Business business, String name) {
        this.business = business;
        this.name = name;
    }

    public Set<Schedule> getAppointments() {
        return appointments;
    }

    public Business getBusiness() {
        return business;
    }

    public String getName() {
        return name;
    }

    public Set<ProfessionalService> getServiceList() {
        return serviceList;
    }
}
