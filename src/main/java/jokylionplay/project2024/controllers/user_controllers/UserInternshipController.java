package jokylionplay.project2024.controllers.user_controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jokylionplay.project2024.services.InternshipService;
import jokylionplay.project2024.services.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "User Стажировки",
        description = "Просмотр стажировок и регистрация")
@RestController
@RequestMapping("/user/{usedId}")
@AllArgsConstructor
public class UserInternshipController {
    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private InternshipService internshipService;


    @Operation(summary = "Регистрация на стажировку",
            description = "Связывает стажировку и пользователя, проверяет не записан ли уже пользователь")
    @PostMapping("/registration")
    public ResponseEntity<Boolean> registrationInternship(
            @Parameter(description = "Id пользователя, доступно из имени запроса")
            @PathVariable
            Long usedId,
            @Parameter(description = "DTO пуст, кроме ID стажировки")
            @RequestParam("id")
            Long internshipId){
        try{
            registrationService.internshipRegistration(internshipId, usedId);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/internships")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(internshipService.getAll(), HttpStatus.OK);
    }
}
