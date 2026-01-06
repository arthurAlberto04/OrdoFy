package com.br.ordofy.ordofy_api.dtos;

public record ViaCepResponseDTO( String cep,
                                 String logradouro,
                                 String bairro,
                                 String localidade,
                                 String estado) {
}
