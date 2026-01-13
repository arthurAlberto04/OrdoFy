package com.br.ordofy.ordofy_api.service;


import com.br.ordofy.ordofy_api.dtos.ProfessionalResponseDTO;
import com.br.ordofy.ordofy_api.entities.Professional;
import com.br.ordofy.ordofy_api.repositories.ProfessionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfessionalService {

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
}
