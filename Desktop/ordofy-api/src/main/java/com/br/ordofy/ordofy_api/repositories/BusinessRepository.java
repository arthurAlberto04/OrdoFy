package com.br.ordofy.ordofy_api.repositories;

import com.br.ordofy.ordofy_api.entities.Business;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessRepository extends JpaRepository<Business, Integer> {
}
