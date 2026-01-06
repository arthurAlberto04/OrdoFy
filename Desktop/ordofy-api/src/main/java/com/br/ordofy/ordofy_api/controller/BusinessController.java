package com.br.ordofy.ordofy_api.controller;

import com.br.ordofy.ordofy_api.dtos.BusinessResponseDTO;
import com.br.ordofy.ordofy_api.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
