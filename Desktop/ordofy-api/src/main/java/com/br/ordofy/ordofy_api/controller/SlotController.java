package com.br.ordofy.ordofy_api.controller;

import com.br.ordofy.ordofy_api.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping(value = "/slot")
public class SlotController {
    @Autowired
    private ScheduleService scheduleService;

    @GetMapping("/professional/{professionalId}")
    public ResponseEntity<List<LocalTime>> getSlots(@PathVariable int professionalId, @RequestParam LocalDate date, @RequestParam int serviceId){
        return ResponseEntity.ok(
                scheduleService.getAvailableSlots(professionalId, date, serviceId)
        );
    }
}
