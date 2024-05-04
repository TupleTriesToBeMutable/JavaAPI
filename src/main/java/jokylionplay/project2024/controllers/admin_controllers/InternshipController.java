package jokylionplay.project2024.controllers.admin_controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jokylionplay.project2024.dto.InternshipInfoDTO;
import jokylionplay.project2024.services.InternshipService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Admin Стажировки", description = "Управление стажировками")
@RestController
@RequestMapping("/admin/{adminId}")
@AllArgsConstructor
public class InternshipController {
    private InternshipService internshipService;
    @Operation(summary = "Создание стажировки",
    description = "Создает стадировки, без связей с уроками, заданиями и пользователями")
    @PostMapping("/create-internship")
    public ResponseEntity<InternshipInfoDTO> createInternship(
            @RequestBody @Parameter(description = "DTO без связей и списков")
            InternshipInfoDTO internshipInfoDTO){

        InternshipInfoDTO saved = internshipService.create(internshipInfoDTO);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
}
