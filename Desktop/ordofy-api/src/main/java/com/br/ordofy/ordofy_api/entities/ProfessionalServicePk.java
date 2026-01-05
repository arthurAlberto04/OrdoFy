package com.br.ordofy.ordofy_api.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

@Embeddable
public class ProfessionalServicePk {

    @ManyToOne
    @JoinColumn(name = "professional_id")
    private Professional professional;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;

    public ProfessionalServicePk() {
    }

    public ProfessionalServicePk(Professional professional, Service service) {
        this.professional = professional;
        this.service = service;
    }

    public void setProfessional(Professional professional) {
        this.professional = professional;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Professional getProfessional() {
        return professional;
    }

    public Service getService() {
        return service;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProfessionalServicePk that = (ProfessionalServicePk) o;
        return Objects.equals(getProfessional(), that.getProfessional()) && Objects.equals(getService(), that.getService());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProfessional(), getService());
    }
}
