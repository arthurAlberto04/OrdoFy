package com.br.ordofy.ordofy_api.repositories;

import com.br.ordofy.ordofy_api.entities.Professional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProfessionalRepository extends JpaRepository<Professional, Integer> {
    List<Professional> findByBusinessId(int businessId);
}
