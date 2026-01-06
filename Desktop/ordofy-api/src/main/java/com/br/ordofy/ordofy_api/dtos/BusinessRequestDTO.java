package com.br.ordofy.ordofy_api.dtos;

import com.br.ordofy.ordofy_api.entities.LegalEntity;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BusinessRequestDTO(
        @NotBlank
        String name,
        @Valid
        @NotNull
        AddressRequestDTO address,
        @Valid
        @NotNull
        PhoneRequestDTO phone,
        @Valid
        @NotNull
        LegalEntityRequestDTO legalEntity
) {
}
