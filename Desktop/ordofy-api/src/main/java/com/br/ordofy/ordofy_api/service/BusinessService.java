package com.br.ordofy.ordofy_api.service;

import com.br.ordofy.ordofy_api.dtos.AddressResponseDTO;
import com.br.ordofy.ordofy_api.dtos.BusinessRequestDTO;
import com.br.ordofy.ordofy_api.dtos.BusinessResponseDTO;
import com.br.ordofy.ordofy_api.entities.*;
import com.br.ordofy.ordofy_api.repositories.BusinessRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BusinessService {

    @Autowired
    private BusinessRepository repository;

    @Autowired
    private AddressService addressService;

    public List<BusinessResponseDTO> findAll(){
        return repository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    private BusinessResponseDTO toResponse(Business b){
        AddressResponseDTO dtoAddress = new AddressResponseDTO(b.getAddress().getStreet(), b.getAddress().getNumber(), b.getAddress().getComplement(), b.getAddress().getCity());
        BusinessResponseDTO dto = new BusinessResponseDTO(b.getId(), b.getName(), dtoAddress, b.getPhone().toString());
        return dto;
    }

    public BusinessResponseDTO findById(int id) {
        Optional<Business> b = repository.findById(id);
        if(b.isPresent()){
            return toResponse(b.get());
        }
        throw new RuntimeException();
    }

    public BusinessResponseDTO insert(@Valid BusinessRequestDTO dto) {
        return toResponse(repository.save(toBusiness(dto)));
    }

    private Business toBusiness(@Valid BusinessRequestDTO dto) {
        Phone p = new Phone(dto.phone().areaCode(), dto.phone().countryCode(), dto.phone().phoneNumber());
        LegalEntity le = new LegalEntity(dto.legalEntity().companyName(), new Cnpj(dto.legalEntity().cnpj()), dto.legalEntity().type());
        return new Business(addressService.createAddress(dto.address().zipCode(), dto.address().complement(), dto.address().number()), le, dto.name(), p);
    }
}
