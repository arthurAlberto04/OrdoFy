package com.br.ordofy.ordofy_api.service;

import com.br.ordofy.ordofy_api.dtos.EmailResponseDTO;
import com.br.ordofy.ordofy_api.dtos.UserRequestDTO;
import com.br.ordofy.ordofy_api.dtos.UserResponseDTO;
import com.br.ordofy.ordofy_api.entities.Email;
import com.br.ordofy.ordofy_api.entities.Phone;
import com.br.ordofy.ordofy_api.entities.User;
import com.br.ordofy.ordofy_api.repositories.UserRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public UserResponseDTO findById(int id) {
        return toResponse(userRepository.getReferenceById(id));
    }

    private UserResponseDTO toResponse(User referenceById) {
        return new UserResponseDTO(referenceById.getId(), referenceById.getUsername(), new EmailResponseDTO(referenceById.getEmail().getEmail()), referenceById.getPhone().toString(), referenceById.getBirth());
    }

    public UserResponseDTO insert(UserRequestDTO ur) {
        return toResponse(userRepository.save(toUser(ur)));
    }

    private User toUser(UserRequestDTO ur) {
        return new User(ur.birth(), new Email(ur.email().email()), ur.password(), new Phone(ur.phone().areaCode(), ur.phone().countryCode(), ur.phone().phoneNumber()), ur.username());
    }

    public UserResponseDTO response(User user){
        return toResponse(user);
    }

    public User getEntityById(int id) {
        return userRepository.getReferenceById(id);
    }
}
