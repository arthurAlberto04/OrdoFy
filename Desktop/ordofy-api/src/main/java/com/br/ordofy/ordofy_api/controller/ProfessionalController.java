package com.br.ordofy.ordofy_api.controller;


import com.br.ordofy.ordofy_api.dtos.ProfessionalRequestDTO;
import com.br.ordofy.ordofy_api.dtos.ProfessionalResponseDTO;
import com.br.ordofy.ordofy_api.service.ProfessionalDomainService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/professional")
public class ProfessionalController {

    @Autowired
    private ProfessionalDomainService service;

    @GetMapping
    public ResponseEntity<List<ProfessionalResponseDTO>> getAllByBusinessId(){
        List<ProfessionalResponseDTO> list = service.getAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/business/{id}")
    public ResponseEntity<List<ProfessionalResponseDTO>> getAllByBusinessId(@PathVariable int id){
        List<ProfessionalResponseDTO> list = service.getAllByBusinessId(id);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProfessionalResponseDTO> getById(@PathVariable int id){
        ProfessionalResponseDTO p = service.getById(id);
        return ResponseEntity.ok().body(p);
    }

    @PostMapping
    public ResponseEntity<ProfessionalResponseDTO> insert(@RequestBody @Valid ProfessionalRequestDTO dto){
        ProfessionalResponseDTO p = service.insert(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(p.id()).toUri();
        return ResponseEntity.created(uri).body(p);
    }
}
