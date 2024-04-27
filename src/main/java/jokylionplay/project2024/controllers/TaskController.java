package jokylionplay.project2024.controllers;

import jokylionplay.project2024.dto.TaskDTO;
import jokylionplay.project2024.services.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tasks")
@AllArgsConstructor
public class TaskController {
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskDTO> createTask(@RequestBody TaskDTO dto){
        TaskDTO saved = taskService.createTask(dto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

}
