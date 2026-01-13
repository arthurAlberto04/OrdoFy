package com.br.ordofy.ordofy_api.dtos;


public record BusinessResponseDTO(int id, String name, AddressResponseDTO address, String phone) {
}
