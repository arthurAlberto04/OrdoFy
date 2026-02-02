package com.br.ordofy.ordofy_api.controller;


import com.br.ordofy.ordofy_api.dtos.ProfessionalWorkingHoursRequestDTO;
import com.br.ordofy.ordofy_api.dtos.ProfessionalWorkingHoursResponseDTO;
import com.br.ordofy.ordofy_api.service.ProfessionalWorkingHoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/professionalsHours")
public class ProfessionalWorkingHoursController {

    @Autowired
    private ProfessionalWorkingHoursService service;

    @GetMapping(value = "/business/{id}")
    public ResponseEntity<List<ProfessionalWorkingHoursResponseDTO>> getAllByBusinessId(@PathVariable int id){
        List<ProfessionalWorkingHoursResponseDTO> dto = service.getAllByBusinessId(id);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping(value = "/professional/{id}")
    public ResponseEntity<List<ProfessionalWorkingHoursResponseDTO>> getByProfessionalId(@PathVariable int id){
        List<ProfessionalWorkingHoursResponseDTO> dto = service.getByProfessionalId(id);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping(value = "/professional/{id}/{day}")
    public ResponseEntity<ProfessionalWorkingHoursResponseDTO> getByProfessionalIdAndDayOfWeek(@PathVariable int id, @PathVariable int day){
        ProfessionalWorkingHoursResponseDTO dto = service.getByProfessionalIdAndDayOfWeek(id, day);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<ProfessionalWorkingHoursResponseDTO> insert(@RequestBody ProfessionalWorkingHoursRequestDTO dto){
        ProfessionalWorkingHoursResponseDTO response = service.insert(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("Professional/{id}").buildAndExpand(response.professionalId()).toUri();
        return ResponseEntity.created(uri).body(response);
    }

}
