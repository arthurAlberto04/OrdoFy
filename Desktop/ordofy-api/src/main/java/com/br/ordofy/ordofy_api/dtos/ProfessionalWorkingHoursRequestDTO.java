package com.br.ordofy.ordofy_api.dtos;

import jakarta.validation.constraints.NotNull;

import java.time.LocalTime;

public record ProfessionalWorkingHoursRequestDTO(@NotNull DayOfWeekRequestDTO day, @NotNull LocalTime startTime, @NotNull LocalTime endTime, @NotNull int professionalId) {
}
