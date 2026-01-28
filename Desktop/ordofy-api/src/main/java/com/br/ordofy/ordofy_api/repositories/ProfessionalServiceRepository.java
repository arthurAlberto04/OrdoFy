package com.br.ordofy.ordofy_api.repositories;

import com.br.ordofy.ordofy_api.entities.ProfessionalService;
import com.br.ordofy.ordofy_api.entities.pk.ProfessionalServicePk;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfessionalServiceRepository extends JpaRepository<ProfessionalService, ProfessionalServicePk> {
    List<ProfessionalService> findById_Professional_Id(int id);
    List<ProfessionalService> findById_Service_Id(int id);
}
