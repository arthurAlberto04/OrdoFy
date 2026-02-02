package com.br.ordofy.ordofy_api.service;


import com.br.ordofy.ordofy_api.dtos.DayOfWeekRequestDTO;
import com.br.ordofy.ordofy_api.dtos.DayOfWeekResponseDTO;
import com.br.ordofy.ordofy_api.dtos.ProfessionalWorkingHoursRequestDTO;
import com.br.ordofy.ordofy_api.dtos.ProfessionalWorkingHoursResponseDTO;
import com.br.ordofy.ordofy_api.entities.ProfessionalWorkingHours;
import com.br.ordofy.ordofy_api.entities.enums.DayOfWeek;
import com.br.ordofy.ordofy_api.repositories.ProfessionalWorkingHoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessionalWorkingHoursService {

    @Autowired
    private ProfessionalWorkingHoursRepository repository;

    @Autowired
    private ProfessionalDomainService service;

    public List<ProfessionalWorkingHoursResponseDTO> getAllByBusinessId(int businessId) {
        return repository.findByProfessional_Business_Id(businessId).stream().map(this::toResponse).toList();
    }

    private ProfessionalWorkingHoursResponseDTO toResponse(ProfessionalWorkingHours p) {
        return new ProfessionalWorkingHoursResponseDTO(p.getId(), new DayOfWeekResponseDTO(p.getDayOfWeek().toString()), p.getStartTime(), p.getEndTime(), p.getProfessional().getId());
    }

    public List<ProfessionalWorkingHoursResponseDTO> getByProfessionalId(int professionalId) {
        return repository.findByProfessional_Id(professionalId).stream().map(this::toResponse).toList();
    }

    public ProfessionalWorkingHoursResponseDTO getByProfessionalIdAndDayOfWeek(int professionalId, int day) {
         return toResponse(repository.findByProfessional_IdAndDayOfWeek(professionalId, DayOfWeek.fromNumber(day)));
    }

    public ProfessionalWorkingHoursResponseDTO insert(ProfessionalWorkingHoursRequestDTO dto) {
        return toResponse(repository.save(toEntity(dto)));
    }

    private ProfessionalWorkingHours toEntity(ProfessionalWorkingHoursRequestDTO dto) {
        return new ProfessionalWorkingHours(DayOfWeek.fromNumber(dto.day().day()), dto.endTime(), service.getEntityById(dto.professionalId()), dto.startTime());
    }
}
