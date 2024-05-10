package jokylionplay.project2024.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lessons")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToMany(mappedBy = "lessons")
    private Set<Internship> internships = new HashSet<>();


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "lessons_tasks",
            joinColumns = @JoinColumn(name = "lesson_id"),
            inverseJoinColumns = @JoinColumn(name = "task_id"))
    private Set<Task> tasks = new HashSet<>();


    @Column(name = "name")
    private String name;


    @Column(name = "visibility")
    boolean visibilityToUsers;
}
