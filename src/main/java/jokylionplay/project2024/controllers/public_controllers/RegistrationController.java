package jokylionplay.project2024.controllers.public_controllers;

import jokylionplay.project2024.dto.UserDTO;
import jokylionplay.project2024.entities.User;
import jokylionplay.project2024.mappers.UserMapper;
import jokylionplay.project2024.repository.UserRepository;
import jokylionplay.project2024.services.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registration")
@AllArgsConstructor
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;

    @PostMapping
    public ResponseEntity<?> userRegistration(UserDTO dto){
        registrationService.registration(dto);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
