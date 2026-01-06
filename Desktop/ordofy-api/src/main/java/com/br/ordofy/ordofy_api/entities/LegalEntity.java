package com.br.ordofy.ordofy_api.entities;

import com.br.ordofy.ordofy_api.entities.enums.Type;
import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class LegalEntity {
    private String companyName;
    private Cnpj cnpj;
    private Type type;

    public LegalEntity() {
    }

    public LegalEntity(String companyName, Cnpj cnpj, Type type) {
        this.companyName = companyName;
        this.cnpj = cnpj;
        this.type = type;
    }

    public Cnpj getCnpj() {
        return cnpj;
    }

    public String getCompanyName() {
        return companyName;
    }

    public Type getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LegalEntity that = (LegalEntity) o;
        return Objects.equals(getCnpj(), that.getCnpj());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getCnpj());
    }
}
