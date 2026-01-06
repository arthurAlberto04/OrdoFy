package com.br.ordofy.ordofy_api.service;

import com.br.ordofy.ordofy_api.dtos.ViaCepResponseDTO;
import com.br.ordofy.ordofy_api.entities.Address;
import com.br.ordofy.ordofy_api.entities.ViaCepClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private ViaCepClient viaCepClient;

    public Address createAddress(String zipCode, String complement, int number){
        return toAddress(viaCepClient.buscarCep(zipCode), complement, number);
    }

    private Address toAddress(ViaCepResponseDTO viaCepResponseDTO, String complement, int number) {
        return new Address(viaCepResponseDTO.localidade(), complement, "Brasil", viaCepResponseDTO.bairro(), number, viaCepResponseDTO.estado(), viaCepResponseDTO.cep(), viaCepResponseDTO.logradouro());
    }
}
