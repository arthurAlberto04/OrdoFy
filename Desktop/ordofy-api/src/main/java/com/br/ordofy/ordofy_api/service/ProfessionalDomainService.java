package com.br.ordofy.ordofy_api.service;


import com.br.ordofy.ordofy_api.dtos.ProfessionalRequestDTO;
import com.br.ordofy.ordofy_api.dtos.ProfessionalResponseDTO;
import com.br.ordofy.ordofy_api.entities.Professional;
import com.br.ordofy.ordofy_api.repositories.ProfessionalRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfessionalDomainService {

    @Autowired
    private ProfessionalRepository professionalRepository;

    @Autowired
    private BusinessService businessService;

    public List<ProfessionalResponseDTO> getAll(){
        List<Professional> l = professionalRepository.findAll();
        List<ProfessionalResponseDTO> list = new ArrayList<>();
        for(Professional p : l){
            list.add(toResponse(p));
        }
        return list;
    }

    private ProfessionalResponseDTO toResponse(Professional p){
        return new ProfessionalResponseDTO(p.getId(), p.getName(), businessService.findById(p.getBusiness().getId()));
    }

    private Professional toProfessional(ProfessionalRequestDTO dto) {
        return new Professional(businessService.getReferenceById(dto.businessId()), dto.name());
    }

    public ProfessionalResponseDTO getById(int id) {
        return toResponse(professionalRepository.getReferenceById(id));
    }

    public Professional getEntityById(int id) {
        return professionalRepository.getReferenceById(id);
    }

    public ProfessionalResponseDTO insert(@Valid ProfessionalRequestDTO dto) {
        return toResponse(professionalRepository.save(toProfessional(dto)));
    }

    public ProfessionalResponseDTO response(Professional p){
        return toResponse(p);
    }

    public List<ProfessionalResponseDTO> getAllByBusinessId(int id) {
        List<Professional> l = professionalRepository.findByBusinessId(id);
        List<ProfessionalResponseDTO> list = new ArrayList<>();
        for(Professional p : l){
            list.add(toResponse(p));
        }
        return list;
    }
}
