package jokylionplay.project2024.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.Collection;

@Schema(description = "Данные пользователя")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Schema(description = "ID пользователя")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "Стажировки на которые пользователн записан или был записан")
    @ManyToMany(mappedBy = "users")
    private Collection<Internship> internships;

    @Schema(description = "Выданные задания и их состояния")
    @OneToMany(mappedBy = "id", fetch = FetchType.LAZY)
    private Collection<UserProgress> usersTasks;

    @Schema(description = "ФИО")
    @Column(name = "fullname")
    private String fullname;

    @Schema(description = "Электронная почта")
    @Column(name = "e_mail")
    private String mail;

    @Schema(description = "Никнэйм")
    @Column(name = "username")
    private String username;

    @Schema(description = "Пароль")
    @Column(name = "password")
    private String password;

    @Schema(description = "ID в телеграмме")
    @Column(name = "telegram_id")
    private String telegramId;

    @Schema(description = "Информация о себе")
    @Column(name = "info")
    private String info;

    @Schema(description = "Дата рождения")
    @Column(name = "birthdate")
    private Date birthdate;

    @Schema(description = "Город проживания")
    @Column(name = "city")
    private String city;

    @Schema(description = "Степень обучения в учебных заведениях")
    @Column(name = "study_status")
    private String studyStatus;

    @Schema(description = "Место учебы")
    @Column(name = "place_of_study")
    private String placeOfStudy;

    @Schema(description = "Факультет")
    @Column(name = "faculty")
    private String faculty;

    @Schema(description = "Специальность")
    @Column(name = "specialty")
    private String specialty;

    @Schema(description = "Текущий курс")
    @Column(name = "course")
    private String course;
}
