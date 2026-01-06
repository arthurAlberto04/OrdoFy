package com.br.ordofy.ordofy_api.entities;

import com.br.ordofy.ordofy_api.dtos.ViaCepResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class ViaCepClient {

    private final RestClient restClient;

    public ViaCepClient(RestClient.Builder builder) {
        this.restClient = builder
                .baseUrl("https://viacep.com.br/ws")
                .build();
    }

    public ViaCepResponseDTO buscarCep(String cep) {
        return restClient
                .get()
                .uri("/{cep}/json", cep)
                .retrieve()
                .body(ViaCepResponseDTO.class);
    }
}
