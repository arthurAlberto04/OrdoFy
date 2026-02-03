package com.br.ordofy.ordofy_api.repositories;

import com.br.ordofy.ordofy_api.entities.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {

    List<Schedule> findByProfessional_IdAndDate(int id, LocalDate date);

    List<Schedule> findByProfessional_Business_IdAndDate(int id, LocalDate date);

    List<Schedule> findByProfessional_Id(int id);

    List<Schedule> findByUser_Id(int id);

    List<Schedule> findByService_IdAndProfessional_Business_Id(int id, int businessId);

    List<Schedule> findByUser_usernameAndProfessional_Business_Id(String username, int businessId);
}
