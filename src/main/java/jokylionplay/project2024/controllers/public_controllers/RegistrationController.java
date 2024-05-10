package jokylionplay.project2024.controllers.public_controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jokylionplay.project2024.dto.UserInfoDTO;
import jokylionplay.project2024.entities.Admin;
import jokylionplay.project2024.entities.User;
import jokylionplay.project2024.repository.AdminRepository;
import jokylionplay.project2024.repository.UserRepository;
import jokylionplay.project2024.services.RegistrationService;
import jokylionplay.project2024.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Tag(name = "Public Регистрация новых пользователей",
     description = "Регистрация доступная всем")
@RestController
@RequestMapping("/guest")
@AllArgsConstructor
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;

    @Operation(summary = "Регистрация на сайте",
            description = "Создает нового пользователя, без записи на стажировку")
    @PostMapping("/registration")
    public ResponseEntity<?> userRegistration(
            @Parameter(description = "DTO объект пользователя")
            @RequestBody UserInfoDTO dto){

        String gitlabUrl = "http://localhost:8929";
        String accessToken = "glpat-iGZx_zbfkuzpPyV1CpB8";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(gitlabUrl + "/users"))
                .header("Authorization", "Bearer " + accessToken)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(
                        "{\"username\":\"" + dto.getUsername() + "\"," +
                                "\"email\":\"" + dto.getMail() + "\"," +
                                "\"password\":\"" + dto.getPassword() + "\"}"
                ))
                .build();
        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response  + "\n");
        }
        catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }

        registrationService.registration(dto);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
