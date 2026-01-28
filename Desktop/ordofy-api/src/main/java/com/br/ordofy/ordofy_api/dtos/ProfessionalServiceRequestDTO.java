package com.br.ordofy.ordofy_api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProfessionalServiceRequestDTO(@NotNull int professionalId, @NotNull int serviceId) {
}
