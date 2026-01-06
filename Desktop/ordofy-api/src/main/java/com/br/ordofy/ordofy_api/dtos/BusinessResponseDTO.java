package com.br.ordofy.ordofy_api.dtos;

import com.br.ordofy.ordofy_api.entities.Address;
import com.br.ordofy.ordofy_api.entities.Phone;

public record BusinessResponseDTO(int id, String name, AddressResponseDTO address, String phone) {
}
