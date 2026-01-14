package com.br.ordofy.ordofy_api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProfessionalRequestDTO(@NotBlank String name, @NotNull int businessId) {
}
