package com.br.ordofy.ordofy_api.dtos;

import jakarta.validation.constraints.NotBlank;

public record PhoneRequestDTO(@NotBlank String countryCode, @NotBlank String areaCode, @NotBlank String phoneNumber) {
}
