package jokylionplay.project2024.controllers.user_controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jokylionplay.project2024.dto.UserInfoDTO;
import jokylionplay.project2024.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "User Профиль",
        description = "Просмотр профила и его изменение")
@RestController
@RequestMapping("/user/{userId}")
@AllArgsConstructor
public class UserProfileController {
    @Autowired
    private UserService userService;

    @Operation(summary = "Просмотр профиля",
            description = "Информация о пользователе")
    @GetMapping("/profile")
    public ResponseEntity<?> getProfile(
            @Parameter(description = "Параметр запроса id пользователя")
            @PathVariable
            Long userId){
        try{
            UserInfoDTO user = userService.getInfo(userId);
            return new ResponseEntity<>(user, HttpStatus.FOUND);
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Обвноаление профиля",
            description = "Обновление информации о пользователе")
    @PatchMapping("/profile/update")
    public ResponseEntity<?> updateProfile(
            @Parameter(description = "DTO в котором обновленные данные пользователя")
            @RequestBody
            UserInfoDTO dto){
        try{
            userService.update(dto);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Просмотр стажировок",
            description = "Стажировки на которые записан пользователь")
    @GetMapping("/my-internships-tasks")
    public ResponseEntity<?> listOfInternships(
            @Parameter(description = "Параметр запроса id пользователя")
            @PathVariable
            Long userId){
        try{
            return new ResponseEntity<>(userService.findInternshipsRelatedWithUser(userId), HttpStatus.FOUND);
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Успеваемость",
            description = "Просмотр успеваемости по определенной стажировке")
    @GetMapping("/report")
    public ResponseEntity<?> usersGrade(
            @Parameter(description = "Параметр запроса id стажировки")
            @RequestParam("id")
            Long internshipId,
            @Parameter(description = "Переменная пути id пользователя")
            @PathVariable
            Long userId){
        try{
            return new ResponseEntity<>(
                    userService.getReportByInternshipIdAndUserId(internshipId, userId),
                    HttpStatus.FOUND);
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
