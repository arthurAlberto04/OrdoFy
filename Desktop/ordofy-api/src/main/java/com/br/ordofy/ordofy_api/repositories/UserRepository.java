package com.br.ordofy.ordofy_api.repositories;

import com.br.ordofy.ordofy_api.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
