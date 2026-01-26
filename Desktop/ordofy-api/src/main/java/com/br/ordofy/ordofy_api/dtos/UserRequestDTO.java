package com.br.ordofy.ordofy_api.dtos;

import java.time.Instant;

public record UserRequestDTO(String username, EmailRequestDTO email, String password, Instant birth, PhoneRequestDTO phone) {
}
