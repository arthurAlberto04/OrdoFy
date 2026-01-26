package com.br.ordofy.ordofy_api.dtos;
import java.time.Instant;

public record UserResponseDTO(int id, String username, EmailResponseDTO email, String phone, Instant birth) {
}
