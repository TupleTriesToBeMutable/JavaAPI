package jokylionplay.project2024.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@Schema(description = "Стажировка, связи многие ко многим (пользователи, уроки) ")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "internships")
public class Internship {
    @Schema(description = "ID стажировки")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "Список пользователей")
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "internships_users",
        joinColumns = @JoinColumn(name = "internship_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> users = new HashSet<>();

    @Schema(description = "Список уроков")
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "internships_lessons",
            joinColumns = @JoinColumn(name = "internship_id"),
            inverseJoinColumns = @JoinColumn(name = "lesson_id"))
    private Set<Lesson> lessons = new HashSet<>();

    @Schema(description = "Название")
    @Column(name = "name")
    private String name;

    @Schema(description = "Дата начала стажировки")
    @Column(name = "start_date")
    private Date startDate;

    @Schema(description = "Дата конца стажировки")
    @Column(name = "end_date")
    private Date endDate;

    @Schema(description = "Дата конца регистрации")
    @Column(name = "registration_end")
    private Date registrationEnd;

    @Schema(description = "Статус false - закончилась, true - действующая")
    @Column(name = "status")
    private boolean status;
}
