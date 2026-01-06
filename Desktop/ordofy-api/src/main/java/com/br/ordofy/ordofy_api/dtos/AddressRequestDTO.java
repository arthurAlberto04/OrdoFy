package com.br.ordofy.ordofy_api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AddressRequestDTO(@NotBlank String zipCode, @NotNull String complement, @NotNull Integer number) {
}
