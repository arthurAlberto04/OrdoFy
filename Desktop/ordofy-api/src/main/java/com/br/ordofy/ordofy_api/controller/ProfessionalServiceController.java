package com.br.ordofy.ordofy_api.controller;

import com.br.ordofy.ordofy_api.dtos.ProfessionalResponseDTO;
import com.br.ordofy.ordofy_api.dtos.ProfessionalServiceRequestDTO;
import com.br.ordofy.ordofy_api.dtos.ProfessionalServiceResponseDTO;
import com.br.ordofy.ordofy_api.dtos.ServiceResponseDTO;
import com.br.ordofy.ordofy_api.entities.ProfessionalService;
import com.br.ordofy.ordofy_api.service.ProfessionalServiceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class ProfessionalServiceController {

    @Autowired
    private ProfessionalServiceService professionalServiceService;

    @GetMapping(value = "professional/{id}/service")
    public ResponseEntity<List<ServiceResponseDTO>> getAllServiceByProfessionalId(@PathVariable int id){
        List<ServiceResponseDTO> ps = professionalServiceService.getAllServicesByProfessionalId(id);
        return ResponseEntity.ok().body(ps);
    }

    @GetMapping(value = "service/{id}/professional")
    public ResponseEntity<List<ProfessionalResponseDTO>> getAllProfessionalByServiceId(@PathVariable int id){
        List<ProfessionalResponseDTO> ps = professionalServiceService.getAllProfessionalByServiceId(id);
        return ResponseEntity.ok().body(ps);
    }

    @PostMapping(value = "/professional/service")
    public ResponseEntity<ProfessionalServiceResponseDTO> insert(@RequestBody @Valid ProfessionalServiceRequestDTO dto){
        ProfessionalServiceResponseDTO ps = professionalServiceService.insert(dto.professionalId(), dto.serviceId());
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("Professional/{id}/Service").buildAndExpand(ps.professional().id()).toUri();
        return ResponseEntity.created(uri).body(ps);
    }
}
