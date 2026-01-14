package com.br.ordofy.ordofy_api.dtos;

import java.math.BigDecimal;
import java.time.Duration;

public record ServiceResponseDTO(int id, String name, Duration duration, BigDecimal price) {
}
