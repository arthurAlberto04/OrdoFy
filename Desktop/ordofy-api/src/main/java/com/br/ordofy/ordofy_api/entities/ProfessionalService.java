package com.br.ordofy.ordofy_api.entities;

import java.math.BigDecimal;
import java.time.Duration;

public class ProfessionalService {

    private Professional professional;
    private Service service;
    private boolean active;

    public ProfessionalService(
            Professional professional,
            Service service
    ) {
        this.professional = professional;
        this.service = service;
        this.active = true;
    }

    public boolean isActive() {
        return active;
    }

    public Professional getProfessional() {
        return professional;
    }

    public Service getService() {
        return service;
    }
}
