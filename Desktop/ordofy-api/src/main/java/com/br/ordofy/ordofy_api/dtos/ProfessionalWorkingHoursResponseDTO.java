package com.br.ordofy.ordofy_api.dtos;

import java.time.LocalTime;

public record ProfessionalWorkingHoursResponseDTO(int id, DayOfWeekResponseDTO day, LocalTime startTime, LocalTime endTime, int professionalId) {
}
