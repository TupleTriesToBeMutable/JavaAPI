package jokylionplay.project2024.controllers.public_controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jokylionplay.project2024.dto.UserInfoDTO;
import jokylionplay.project2024.services.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Public Регистрация новых пользователей",
     description = "Регистрация доступная всем")
@RestController
@RequestMapping("/registration")
@AllArgsConstructor
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;

    @Operation(summary = "Регистрация на сайте",
            description = "Создает нового пользователя, без записи на стажировку")
    @PostMapping
    public ResponseEntity<?> userRegistration(
            @Parameter(description = "DTO объект пользователя")
            @RequestBody UserInfoDTO dto){
        registrationService.registration(dto);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
