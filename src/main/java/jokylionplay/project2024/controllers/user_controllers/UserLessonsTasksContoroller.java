package jokylionplay.project2024.controllers.user_controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "User Задания и уроки",
        description = "Просмотр проходимых стажировок, уроков и заданий")
@RestController
@RequestMapping("/user/{usedId}/internships")
@AllArgsConstructor
public class UserLessonsTasksContoroller {
}
