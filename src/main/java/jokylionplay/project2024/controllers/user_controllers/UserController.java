package jokylionplay.project2024.controllers.user_controllers;

import jokylionplay.project2024.dto.InternshipDTO;
import jokylionplay.project2024.services.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/{usedId}")
@AllArgsConstructor
public class UserController {
    private RegistrationService registrationService;

    @PostMapping("/internship-registration")
    public ResponseEntity<Boolean> registrationInternship(
            @PathVariable Long usedId,
            @RequestBody InternshipDTO internship){
        try{
            registrationService.internshipRegistration(internship.getId(), usedId);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
