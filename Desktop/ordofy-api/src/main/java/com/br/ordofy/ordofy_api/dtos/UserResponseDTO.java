package com.br.ordofy.ordofy_api.dtos;
import java.time.Instant;

public record UserResponseDTO(String username, EmailResponseDTO email, String phone, Instant birth) {
}
