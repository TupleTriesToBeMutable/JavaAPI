package jokylionplay.project2024.controllers;

import jokylionplay.project2024.dto.InternshipDTO;
import jokylionplay.project2024.dto.TaskDTO;
import jokylionplay.project2024.dto.UserDTO;
import jokylionplay.project2024.services.RegistrationService;
import jokylionplay.project2024.services.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
@AllArgsConstructor
public class TaskController {
    private TaskService taskService;

    private RegistrationService registrationService;

    @PostMapping("/create")
    public ResponseEntity<TaskDTO> createTask(@RequestBody TaskDTO dto){
        TaskDTO saved = taskService.createTask(dto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PostMapping("/reg")
    public ResponseEntity<UserDTO> registration(@RequestBody UserDTO user){
        UserDTO savedUser = registrationService.userRegistration(user);
        return new ResponseEntity<>(savedUser, HttpStatus.ACCEPTED);
    }

    @PostMapping("/{id}/reginter")
    public ResponseEntity<Boolean> registrationInternship(
            @PathVariable Long id,
            @RequestBody InternshipDTO internship){
        boolean isDone = registrationService.internshipRegistration(internship.getId(), id);
        return new ResponseEntity<>(isDone, HttpStatus.ACCEPTED);
    }

}
