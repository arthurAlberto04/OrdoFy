package com.br.ordofy.ordofy_api.dtos;

import java.time.LocalDate;
import java.time.LocalTime;

public record ScheduleResponseDTO(int id, LocalDate date, LocalTime start, LocalTime end, ServiceResponseDTO service, UserResponseDTO user,  ProfessionalResponseDTO professional) {
}
