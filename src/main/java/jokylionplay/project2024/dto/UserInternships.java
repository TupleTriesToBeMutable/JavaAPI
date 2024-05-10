package jokylionplay.project2024.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jokylionplay.project2024.entities.Internship;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;
import java.util.Collection;

@Schema(description = "Информации о пользователе со списком проходимых стажировок")
@Data
@AllArgsConstructor
public class UserInternships {

    private Long id;

    private Collection<Internship> internships;

    private String fullname;

    private String mail;

    private String username;

    private String telegramId;

    private String info;

    private Date birthdate;

    private String city;

    private String studyStatus;

    private String placeOfStudy;

    private String faculty;

    private String specialty;

    private String course;
}
