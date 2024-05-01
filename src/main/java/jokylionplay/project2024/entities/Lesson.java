package jokylionplay.project2024.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Collection;


@Schema(description = "Уроки, связи многие ко многим (уроки, задания) ")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lessons")
public class Lesson {
    @Schema(description = "ID урока")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "Список стажировок, где они применяются")
    @ManyToMany(mappedBy = "lessons")
    private Collection<Internship> internships;

    @Schema(description = "Список заданий входящих в урок")
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "lessons_tasks",
            joinColumns = @JoinColumn(name = "lesson_id"),
            inverseJoinColumns = @JoinColumn(name = "task_id"))
    private Collection<Task> tasks;

    @Schema(description = "Название")
    @Column(name = "name")
    private String name;
}
