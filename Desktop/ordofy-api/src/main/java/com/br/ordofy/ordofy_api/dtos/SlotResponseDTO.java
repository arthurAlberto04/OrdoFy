package com.br.ordofy.ordofy_api.dtos;

import java.time.LocalTime;

public record SlotResponseDTO(LocalTime start, boolean busy) {
}
