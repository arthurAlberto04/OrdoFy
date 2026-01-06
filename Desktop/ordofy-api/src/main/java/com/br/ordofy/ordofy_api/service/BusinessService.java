package com.br.ordofy.ordofy_api.service;

import com.br.ordofy.ordofy_api.dtos.AddressResponseDTO;
import com.br.ordofy.ordofy_api.dtos.BusinessResponseDTO;
import com.br.ordofy.ordofy_api.entities.Business;
import com.br.ordofy.ordofy_api.repositories.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BusinessService {

    @Autowired
    private BusinessRepository repository;

    public List<BusinessResponseDTO> findAll(){
        List<Business> list = repository.findAll();
        List<BusinessResponseDTO> listResponse = new ArrayList<>();
        for(Business b : list){
            BusinessResponseDTO dto = toResponse(b);
            listResponse.add(dto);
        }
        return listResponse;
    }

    private BusinessResponseDTO toResponse(Business b){
        AddressResponseDTO dtoAddress = new AddressResponseDTO(b.getAddress().getStreet(), b.getAddress().getNumber(), b.getAddress().getComplement(), b.getAddress().getCity());
        BusinessResponseDTO dto = new BusinessResponseDTO(b.getName(), dtoAddress, b.getPhone().toString());
        return dto;
    }

}
