package jokylionplay.project2024.controllers.admin_controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jokylionplay.project2024.services.ProgressReportService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Admin Статистика", description = "Статистика по прохождению стажировки")
@RestController
@RequestMapping("/admin/{adminId}/internships/{internshipId}")
@AllArgsConstructor
public class ProgressReportController {

    @Autowired
    private ProgressReportService progressReportService;

    @Operation(summary = "Выполнение стажировки",
            description = "Успеваемость всех студентов на определнной стажировке")
    @GetMapping("/report")
    public ResponseEntity<?> create(
            @Parameter(description = "Переменная пути id стажировки")
            @PathVariable("internshipId")
            Long internshipId){
        try {
            return new ResponseEntity<>(progressReportService.getReportByInternshipId(internshipId), HttpStatus.FOUND);
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
