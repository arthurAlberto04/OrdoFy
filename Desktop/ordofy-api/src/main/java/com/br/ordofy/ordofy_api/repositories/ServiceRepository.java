package com.br.ordofy.ordofy_api.repositories;

import com.br.ordofy.ordofy_api.entities.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Integer> {
}
