package com.br.ordofy.ordofy_api.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "tb_professional_service")
public class ProfessionalService {

    @EmbeddedId
    private ProfessionalServicePk id = new ProfessionalServicePk();

    private Boolean active;

    public ProfessionalService() {
    }

    public ProfessionalService(Professional p, Service s){
        id.setService(s);
        id.setProfessional(p);
        active = true;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Professional getProfessional(){
        return id.getProfessional();
    }

    public void setProfessional(Professional p){
        id.setProfessional(p);
    }

    public Service getService(){
        return id.getService();
    }

    public void setService(Service s){
        id.setService(s);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProfessionalService that = (ProfessionalService) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
