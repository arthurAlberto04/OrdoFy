package com.br.ordofy.ordofy_api.controller;

import com.br.ordofy.ordofy_api.dtos.BusinessRequestDTO;
import com.br.ordofy.ordofy_api.dtos.BusinessResponseDTO;
import com.br.ordofy.ordofy_api.service.BusinessService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/business")
public class BusinessController {

    @Autowired
    private BusinessService service;

    @GetMapping
    public ResponseEntity<List<BusinessResponseDTO>> findAll(){
        List<BusinessResponseDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<BusinessResponseDTO> findById(@PathVariable int id){
        BusinessResponseDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<BusinessResponseDTO> insert(@RequestBody @Valid BusinessRequestDTO dto){
        BusinessResponseDTO dtoResponse = service.insert(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(dtoResponse.id()).toUri();
        return ResponseEntity.created(uri).body(dtoResponse);
    }
}
