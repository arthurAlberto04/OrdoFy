package com.br.ordofy.ordofy_api.service;

import com.br.ordofy.ordofy_api.dtos.ServiceRequestDTO;
import com.br.ordofy.ordofy_api.dtos.ServiceResponseDTO;
import com.br.ordofy.ordofy_api.repositories.ServiceRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceDomainService {

    @Autowired
    private ServiceRepository serviceRepository;


    public List<ServiceResponseDTO> getAll() {
        List<com.br.ordofy.ordofy_api.entities.Service> list = serviceRepository.findAll();
        List<ServiceResponseDTO> dto = new ArrayList<>();
        for(com.br.ordofy.ordofy_api.entities.Service s : list){
            dto.add(toResponse(s));
        }
        return dto;
    }

    private ServiceResponseDTO toResponse(com.br.ordofy.ordofy_api.entities.Service s) {
        return new ServiceResponseDTO(s.getId(), s.getName(), s.getDuration(), s.getPrice());
    }

    public ServiceResponseDTO getById(int id) {
        return toResponse(serviceRepository.getReferenceById(id));
    }

    public ServiceResponseDTO response(com.br.ordofy.ordofy_api.entities.Service s) {
        return toResponse(s);
    }

    public ServiceResponseDTO insert(@Valid ServiceRequestDTO dto) {
        return toResponse(serviceRepository.save(toService(dto)));
    }

    private com.br.ordofy.ordofy_api.entities.Service toService(@Valid ServiceRequestDTO dto) {
        return new com.br.ordofy.ordofy_api.entities.Service(dto.duration(), dto.name(), dto.price());
    }

    public com.br.ordofy.ordofy_api.entities.Service getEntityById(int serviceId) {
        return serviceRepository.getReferenceById(serviceId);
    }
}
