package com.br.ordofy.ordofy_api.dtos;

import jakarta.validation.constraints.NotBlank;

public record ProfessionalServiceResponseDTO(Boolean active, ProfessionalResponseDTO professional, ServiceResponseDTO service) {
}
