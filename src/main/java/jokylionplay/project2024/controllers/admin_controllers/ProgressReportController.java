package jokylionplay.project2024.controllers.admin_controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Admin Статистика", description = "Статистика по прохождению стажировки")
@RestController
@RequestMapping("/admin/{adminId}/internships/{internshipId}/report")
@AllArgsConstructor
public class ProgressReportController {
}
