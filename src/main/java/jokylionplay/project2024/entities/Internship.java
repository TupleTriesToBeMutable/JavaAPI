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



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "internships")
public class Internship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "internships_users",
        joinColumns = @JoinColumn(name = "internship_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> users = new HashSet<>();


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "internships_lessons",
            joinColumns = @JoinColumn(name = "internship_id"),
            inverseJoinColumns = @JoinColumn(name = "lesson_id"))
    private Set<Lesson> lessons = new HashSet<>();


    @Column(name = "name")
    private String name;


    @Column(name = "start_date")
    private Date startDate;


    @Column(name = "end_date")
    private Date endDate;


    @Column(name = "registration_end")
    private Date registrationEnd;

    @Schema(description = "Статус false - закончилась, true - действующая")
    @Column(name = "status")
    private boolean status;
}
