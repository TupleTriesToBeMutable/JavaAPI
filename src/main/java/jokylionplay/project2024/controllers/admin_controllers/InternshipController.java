package jokylionplay.project2024.controllers.admin_controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jokylionplay.project2024.dto.InternshipInfoDTO;
import jokylionplay.project2024.dto.LessonInfoDTO;
import jokylionplay.project2024.dto.LessonTasksDTO;
import jokylionplay.project2024.repository.LessonRepository;
import jokylionplay.project2024.services.InternshipService;
import jokylionplay.project2024.services.LessonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@Tag(name = "Admin Стажировки", description = "Управление стажировками")
@RestController
@RequestMapping("/admin/{adminId}/internships")
@AllArgsConstructor
public class InternshipController {
    @Autowired
    private InternshipService internshipService;

    @Autowired
    private LessonService lessonService;

    @Operation(summary = "Создание стажировки",
    description = "Создает стадировки, без связей с уроками, заданиями и пользователями")
    @PostMapping("/create")
    public ResponseEntity<InternshipInfoDTO> create(
            @RequestBody @Parameter(description = "DTO без связей и списков")
            InternshipInfoDTO internshipInfoDTO){

        InternshipInfoDTO saved = internshipService.create(internshipInfoDTO);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @Operation(summary = "Удаление стажировки",
            description = "Удаляет стажировку, если нет никаких связей с ней")
    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(
            @RequestBody @Parameter(description = "Id стажировки")
            InternshipInfoDTO internshipInfoDTO){

        try {
            internshipService.delete(internshipInfoDTO.getId());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (IllegalArgumentException  e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Изменение данных стажировки",
            description = "Изменяет только обычный данные, связи те же остаются")
    @PatchMapping("/update")
    public ResponseEntity<?> update(
            @RequestBody @Parameter(description = "Id стажировки")
            InternshipInfoDTO internshipInfoDTO){

        try {
            internshipService.update(internshipInfoDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (IllegalArgumentException  e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Изменение данных стажировки",
            description = "Изменяет только обычный данные, связи те же остаются")
    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(internshipService.getAll(), HttpStatus.OK);
    }

    @Operation(summary = "Список уроков",
            description = "Список уроков этой стажировки")
    @GetMapping("/lessonslist")
    public ResponseEntity<List<LessonTasksDTO>> lessonsList(
            @Parameter(description = "DTO без связей и списков")
            @RequestBody
            InternshipInfoDTO internshipId){
        return new ResponseEntity<>(internshipService.getAllInInternship(internshipId.getId()), HttpStatus.FOUND);
    }
}
