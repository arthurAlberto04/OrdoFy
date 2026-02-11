package com.br.ordofy.ordofy_api.controller;


import com.br.ordofy.ordofy_api.dtos.ScheduleRequestDTO;
import com.br.ordofy.ordofy_api.dtos.ScheduleResponseDTO;
import com.br.ordofy.ordofy_api.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService service;

    @GetMapping(value = "/professional/{id}")
    public ResponseEntity<List<ScheduleResponseDTO>> getAllByProfessionalIdAndDate(@PathVariable int id, @RequestParam LocalDate date){
        List<ScheduleResponseDTO> dto = service.getByProfessionalIdAndDate(id, date);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping(value = "/business/{id}")
    public ResponseEntity<List<ScheduleResponseDTO>> getByBusinessIdAndDate(@PathVariable int id, @RequestParam LocalDate date){
        List<ScheduleResponseDTO> dto = service.getByBusinessIdAndDate(id, date);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ScheduleResponseDTO> getById(@PathVariable int id){
        ScheduleResponseDTO dto = service.getById(id);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping(value = "/professional/{id}/all")
    public ResponseEntity<List<ScheduleResponseDTO>> getAllByProfessionalId(@PathVariable int id){
        List<ScheduleResponseDTO> dto = service.getByProfessionalId(id);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping(value = "/service/{id}/business/{businessId}")
    public ResponseEntity<List<ScheduleResponseDTO>> getByServiceIdAndBusinessId(@PathVariable int id, @PathVariable int businessId){
        List<ScheduleResponseDTO> dto = service.getByServiceIdAndBusinessId(id, businessId);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping(value = "/user/{id}")
    public ResponseEntity<List<ScheduleResponseDTO>> getAllByUserId(@PathVariable int id){
        List<ScheduleResponseDTO> dto = service.getByUserId(id);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping(value = "/user/business/{businessId}")
    public ResponseEntity<List<ScheduleResponseDTO>> getAllByUsername(@RequestParam String username, @PathVariable int businessId){
        List<ScheduleResponseDTO> dto = service.getByUsername(username, businessId);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<ScheduleResponseDTO> insert(@RequestBody ScheduleRequestDTO dto){
        ScheduleResponseDTO response = service.insert(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(response.id()).toUri();
        return ResponseEntity.created(uri).body(response);
    }
}
