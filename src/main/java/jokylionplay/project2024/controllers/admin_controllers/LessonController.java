package jokylionplay.project2024.controllers.admin_controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jokylionplay.project2024.dto.InternshipInfoDTO;
import jokylionplay.project2024.dto.LessonInfoDTO;
import jokylionplay.project2024.dto.LessonTasksDTO;
import jokylionplay.project2024.dto.TaskInfoDTO;
import jokylionplay.project2024.services.LessonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Admin Уроки", description = "Управление уроками")
@RestController
@RequestMapping("/admin/{adminId}/internships/{internshipId}/lessons")
@AllArgsConstructor
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @Operation(summary = "Создание урока",
            description = "Создание уроков и подкрепление к стажировке")
    @PostMapping("/create")
    public ResponseEntity<LessonInfoDTO> create(
            @Parameter(description = "DTO только с информацией")
            @RequestBody
            LessonInfoDTO lessonInfoDTO,
            @Parameter(description = "Переменная пути id стажировки")
            @PathVariable
            Long internshipId){

        LessonInfoDTO saved = lessonService.create(lessonInfoDTO);
        try {
            lessonService.addToInternship(saved.getId(), internshipId);
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @Operation(summary = "Удаление из стажировки",
            description = "Удаляет из одной конкретной стажировки")
    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(
            @Parameter(description = "Парметр запроса id урока")
            @RequestParam("id")
            Long lessonId,
            @Parameter(description = "Переменная пути id стажировки")
            @PathVariable
            Long internshipId){
        try{
            lessonService.removeFromInternship(lessonId, internshipId);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Обновление информации о уроке",
            description = "Обновление имени, самого задания")
    @PatchMapping("/update")
    public ResponseEntity<?> update(
            @Parameter(description = "DTO без связей")
            @RequestBody
            LessonInfoDTO dto){
        try{
            lessonService.update(dto);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Список заданий",
            description = "Список заданий этого урока")
    @GetMapping("/tasks")
    public ResponseEntity<List<TaskInfoDTO>> taskList(
            @Parameter(description = "Парметр запроса id урока")
            @RequestParam("id")
            Long id){
        return new ResponseEntity<>(lessonService.getTasks(id), HttpStatus.FOUND);
    }

}
