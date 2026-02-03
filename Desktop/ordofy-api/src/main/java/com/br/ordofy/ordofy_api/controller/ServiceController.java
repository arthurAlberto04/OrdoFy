package com.br.ordofy.ordofy_api.controller;

import com.br.ordofy.ordofy_api.dtos.ServiceRequestDTO;
import com.br.ordofy.ordofy_api.dtos.ServiceResponseDTO;
import com.br.ordofy.ordofy_api.service.ServiceDomainService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/service")
public class ServiceController {

    @Autowired
    private ServiceDomainService service;

    @GetMapping
    public ResponseEntity<List<ServiceResponseDTO>> getAll(){
        List<ServiceResponseDTO> dto = service.getAll();
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceResponseDTO> getById(@PathVariable int id){
        ServiceResponseDTO dto = service.getById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<ServiceResponseDTO> insert(@RequestBody @Valid ServiceRequestDTO dto){
        ServiceResponseDTO sr = service.insert(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(sr.id()).toUri();
        return ResponseEntity.created(uri).body(sr);
    }
}
