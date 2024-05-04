package jokylionplay.project2024.controllers.admin_controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jokylionplay.project2024.dto.TaskInfoDTO;
import jokylionplay.project2024.services.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Admin Задания", description = "Управление заданиями")
@RestController
@RequestMapping("/admin/{adminId}")
@AllArgsConstructor
public class TaskController {
    private TaskService taskService;

    @Operation(summary = "Создание заданий",
            description = "Создает задание, без связи с уроками")
    @PostMapping("/create")
    public ResponseEntity<TaskInfoDTO> createTask(
            @Parameter(description = "DTO объект")
            @RequestBody TaskInfoDTO dto){
        TaskInfoDTO saved = taskService.create(dto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

}
