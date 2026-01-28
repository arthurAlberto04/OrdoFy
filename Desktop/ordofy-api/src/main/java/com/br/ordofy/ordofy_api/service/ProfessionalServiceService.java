package com.br.ordofy.ordofy_api.service;

import com.br.ordofy.ordofy_api.dtos.ProfessionalResponseDTO;
import com.br.ordofy.ordofy_api.dtos.ProfessionalServiceResponseDTO;
import com.br.ordofy.ordofy_api.dtos.ServiceResponseDTO;
import com.br.ordofy.ordofy_api.entities.Professional;
import com.br.ordofy.ordofy_api.entities.ProfessionalService;
import com.br.ordofy.ordofy_api.entities.pk.ProfessionalServicePk;
import com.br.ordofy.ordofy_api.repositories.ProfessionalServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfessionalServiceService {

    @Autowired
    private ProfessionalServiceRepository professionalServiceRepository;

    @Autowired
    private ProfessionalDomainService professionalService;

    @Autowired
    private ServiceService serviceService;

    public List<ServiceResponseDTO> getAllServicesByProfessionalId(int id) {
        return professionalServiceRepository.findById_Professional_Id(id)
                .stream()
                .map(ps -> serviceService.response(ps.getService()))
                .toList();
    }

    private ProfessionalServiceResponseDTO toResponse(ProfessionalService p) {
        return new ProfessionalServiceResponseDTO(p.getActive(), professionalService.response(p.getProfessional()), serviceService.response(p.getService()));
    }

    public List<ProfessionalResponseDTO> getAllProfessionalByServiceId(int id) {
        return professionalServiceRepository.findById_Service_Id(id)
                .stream()
                .map(ps -> professionalService.response(ps.getProfessional()))
                .toList();
    }

    public ProfessionalServiceResponseDTO insert(int professionalId, int serviceId) {
        Professional p = professionalService.getEntityById(professionalId);
        com.br.ordofy.ordofy_api.entities.Service s = serviceService.getEntityById(serviceId);

        ProfessionalServicePk pk = new ProfessionalServicePk(p, s);

        if (professionalServiceRepository.existsById(pk)) {
            throw new RuntimeException("Professional already offers this service");
        }

        ProfessionalService ps = new ProfessionalService(p, s);

        professionalServiceRepository.save(ps);
        return toResponse(ps);
    }
}
