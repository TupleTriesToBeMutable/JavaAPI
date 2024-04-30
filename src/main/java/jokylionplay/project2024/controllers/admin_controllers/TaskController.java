package jokylionplay.project2024.controllers.admin_controllers;

import jokylionplay.project2024.dto.InternshipDTO;
import jokylionplay.project2024.dto.TaskDTO;
import jokylionplay.project2024.dto.UserDTO;
import jokylionplay.project2024.repository.InternshipRepository;
import jokylionplay.project2024.services.InternshipService;
import jokylionplay.project2024.services.RegistrationService;
import jokylionplay.project2024.services.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/{adminId}")
@AllArgsConstructor
public class TaskController {
    private TaskService taskService;

    @PostMapping("/create")
    public ResponseEntity<TaskDTO> createTask(@RequestBody TaskDTO dto){
        TaskDTO saved = taskService.createTask(dto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

}
