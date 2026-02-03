package com.br.ordofy.ordofy_api.dtos;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

public record ScheduleRequestDTO(@NotNull LocalDate date, @NotNull LocalTime start, @NotNull int serviceId, @NotNull int userId, @NotNull int professionalId) {
}
