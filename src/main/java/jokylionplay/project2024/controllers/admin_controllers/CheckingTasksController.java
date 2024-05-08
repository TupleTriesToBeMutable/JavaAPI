package jokylionplay.project2024.controllers.admin_controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Admin Проверка заданий", description = "Решено или не решено, оставление комментария")
@RestController
@RequestMapping("/admin/{adminId}/user/{userId}/updated-tasks")
@AllArgsConstructor
public class CheckingTasksController {

}
