package jokylionplay.project2024.dto;

import jokylionplay.project2024.entities.Internship;
import jokylionplay.project2024.entities.UserProgress;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;
import java.util.Collection;

@Data
@AllArgsConstructor
public class UserDTO {

    private Long id;

    private Collection<Internship> internships;

    private Collection<UserProgress> usersTasks;

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
