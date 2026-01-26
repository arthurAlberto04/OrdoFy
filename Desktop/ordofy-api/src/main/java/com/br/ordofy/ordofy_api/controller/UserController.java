package com.br.ordofy.ordofy_api.controller;

import com.br.ordofy.ordofy_api.dtos.UserRequestDTO;
import com.br.ordofy.ordofy_api.dtos.UserResponseDTO;
import com.br.ordofy.ordofy_api.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserResponseDTO> getUser(@PathVariable int id){
        UserResponseDTO dto = userService.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> insert(@RequestBody @Valid UserRequestDTO ur){
        UserResponseDTO dto = userService.insert(ur);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(dto.id()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
}
