package jokylionplay.project2024.controllers.user_controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jokylionplay.project2024.dto.InternshipDTO;
import jokylionplay.project2024.services.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "User Пользовательские запросы",
    description = "Регистрация на стажировку, просмотр заданий, ...")
@RestController
@RequestMapping("/{usedId}")
@AllArgsConstructor
public class UserController {
    private RegistrationService registrationService;

    @Operation(summary = "Регистрация на стажировку",
            description = "Связывает стажировку и пользователя, проверяет не записан ли уже пользователь")
    @PostMapping("/internship-registration")
    public ResponseEntity<Boolean> registrationInternship(
            @Parameter(description = "Id пользователя, доступно из имени запроса")
            @PathVariable Long usedId,
            @Parameter(description = "DTO пуст, кроме ID стажировки")
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
