package com.br.ordofy.ordofy_api.service;

import com.br.ordofy.ordofy_api.dtos.ScheduleRequestDTO;
import com.br.ordofy.ordofy_api.dtos.ScheduleResponseDTO;
import com.br.ordofy.ordofy_api.entities.Professional;
import com.br.ordofy.ordofy_api.entities.Schedule;
import com.br.ordofy.ordofy_api.entities.User;
import com.br.ordofy.ordofy_api.repositories.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository repository;

    @Autowired
    private UserService userService;

    @Autowired
    private ServiceDomainService serviceService;

    @Autowired
    private ProfessionalDomainService professionalDomainService;

    public List<ScheduleResponseDTO> getByProfessionalIdAndDate(int id, LocalDate date) {
        return repository.findByProfessional_IdAndDate(id, date).stream().map(this::toResponse).toList();
    }

    private ScheduleResponseDTO toResponse(Schedule schedule){
        return new ScheduleResponseDTO(schedule.getId(), schedule.getDate(),
                schedule.getStart(), schedule.getEnd(),
                serviceService.response(schedule.getService()),
                userService.response(schedule.getUser()),
                professionalDomainService.response(schedule.getProfessional())
        );
    }

    public List<ScheduleResponseDTO> getByBusinessIdAndDate(int id, LocalDate date) {
        return repository.findByProfessional_Business_IdAndDate(id, date).stream().map(this::toResponse).toList();
    }

    public ScheduleResponseDTO getById(int id) {
        return toResponse(repository.getReferenceById(id));
    }

    public List<ScheduleResponseDTO> getByProfessionalId(int id) {
        return repository.findByProfessional_Id(id).stream().map(this::toResponse).toList();
    }

    public List<ScheduleResponseDTO> getByUserId(int id) {
        return repository.findByUser_Id(id).stream().map(this::toResponse).toList();
    }

    public List<ScheduleResponseDTO> getByServiceIdAndBusinessId(int id, int businessId) {
        return repository.findByService_IdAndProfessional_Business_Id(id, businessId).stream().map(this::toResponse).toList();
    }

    public List<ScheduleResponseDTO> getByUsername(String username, int businessId) {
        return repository.findByUser_usernameAndProfessional_Business_Id(username, businessId).stream().map(this::toResponse).toList();
    }

    public ScheduleResponseDTO insert(ScheduleRequestDTO dto) {
        return toResponse(repository.save(toEntity(dto)));
    }

    private Schedule toEntity(ScheduleRequestDTO dto) {
        com.br.ordofy.ordofy_api.entities.Service s = serviceService.getEntityById(dto.serviceId());
        Professional p = professionalDomainService.getEntityById(dto.professionalId());
        User user = userService.getEntityById(dto.userId());
        return new Schedule(dto.date(), dto.start().plus(s.getDuration()), p, s, dto.start(), user );
    }
}
