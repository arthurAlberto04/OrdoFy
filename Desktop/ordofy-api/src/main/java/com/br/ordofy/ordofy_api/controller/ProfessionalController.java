package com.br.ordofy.ordofy_api.controller;


import com.br.ordofy.ordofy_api.dtos.ProfessionalRequestDTO;
import com.br.ordofy.ordofy_api.dtos.ProfessionalResponseDTO;
import com.br.ordofy.ordofy_api.service.ProfessionalService;
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
    private ProfessionalService service;

    @GetMapping
    public ResponseEntity<List<ProfessionalResponseDTO>> getAll(){
        List<ProfessionalResponseDTO> list = service.getAll();
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
