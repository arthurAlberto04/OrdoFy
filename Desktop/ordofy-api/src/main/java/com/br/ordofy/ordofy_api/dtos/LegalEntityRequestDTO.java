package com.br.ordofy.ordofy_api.dtos;

import com.br.ordofy.ordofy_api.entities.enums.Type;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LegalEntityRequestDTO(@NotBlank String companyName,
                                    @NotBlank String cnpj,
                                    @NotNull Type type) {
}
