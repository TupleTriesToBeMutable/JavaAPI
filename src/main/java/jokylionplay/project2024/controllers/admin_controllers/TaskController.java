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
@RequestMapping("/admin/{adminId}/internships/{internshipId}/lessons/{lessonId}/tasks")
@AllArgsConstructor
public class TaskController {
    private TaskService taskService;

    @Operation(summary = "Создание заданий",
            description = "Создает задание, без связи с уроками")
    @PostMapping("/create")
    public ResponseEntity<TaskInfoDTO> create(
            @Parameter(description = "DTO объект")
            @RequestBody
            TaskInfoDTO dto){
        TaskInfoDTO saved = taskService.create(dto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @Operation(summary = "Удаление заданий",
            description = "Удаление, если не связан ни с чем")
    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(
            @Parameter(description = "Параметр запроса id задания")
            @RequestParam("id")
            Long id){
        try {
            taskService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Изменение задания",
            description = "Изменение данных, без связей")
    @PatchMapping ("/update")
    public ResponseEntity<?> update(
            @Parameter(description = "DTO для обновления")
            @RequestBody
            TaskInfoDTO dto){
        try {
            taskService.update(dto);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
