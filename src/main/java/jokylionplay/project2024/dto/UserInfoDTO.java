package jokylionplay.project2024.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;

@Schema(description = "Информация о пользователе")
@Data
@AllArgsConstructor
public class UserInfoDTO {

    private Long id;

    private String fullname;

    private String mail;

    private String username;

    private String password;

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
