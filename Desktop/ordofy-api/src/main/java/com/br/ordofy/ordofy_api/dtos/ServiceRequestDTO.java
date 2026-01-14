package com.br.ordofy.ordofy_api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.Duration;

public record ServiceRequestDTO(@NotBlank String name, @NotNull @Positive BigDecimal price, @NotNull Duration duration) {
}
