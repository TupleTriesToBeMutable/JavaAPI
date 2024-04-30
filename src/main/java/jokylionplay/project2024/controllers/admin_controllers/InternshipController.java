package jokylionplay.project2024.controllers.admin_controllers;

import jokylionplay.project2024.dto.InternshipDTO;
import jokylionplay.project2024.services.InternshipService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/{adminId}")
@AllArgsConstructor
public class InternshipController {
    private InternshipService internshipService;

    @PostMapping("/create-internship")
    public ResponseEntity<InternshipDTO> createInternship(@RequestBody InternshipDTO internshipDTO){
        InternshipDTO saved = internshipService.create(internshipDTO);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
}
