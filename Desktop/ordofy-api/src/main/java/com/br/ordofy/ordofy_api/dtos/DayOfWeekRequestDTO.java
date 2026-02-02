package com.br.ordofy.ordofy_api.dtos;

import jakarta.validation.constraints.NotNull;

public record DayOfWeekRequestDTO(@NotNull int day) {
}
