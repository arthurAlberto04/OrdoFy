package com.br.ordofy.ordofy_api.repositories;

import com.br.ordofy.ordofy_api.entities.ProfessionalWorkingHours;
import com.br.ordofy.ordofy_api.entities.enums.DayOfWeek;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfessionalWorkingHoursRepository extends JpaRepository<ProfessionalWorkingHours, Integer> {

    List<ProfessionalWorkingHours> findByProfessional_Business_Id(int businessId);

    List<ProfessionalWorkingHours> findByProfessional_Id(int professionalId);

    ProfessionalWorkingHours findByProfessional_IdAndDayOfWeek(int professionalId, DayOfWeek day);
}
