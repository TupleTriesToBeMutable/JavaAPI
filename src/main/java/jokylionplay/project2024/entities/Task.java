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

@Schema(description = "Задания, связи многие ко многим (задания), один ко многим(пользователи) ")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Task")
public class Task {

    @Schema(description = "ID задания")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "Список уроков, в которые ыходят эти задания")
    @ManyToMany(mappedBy = "tasks")
    private Set<Lesson> lessons = new HashSet<>();

    @Schema(description = "Список пользователей, у которых есть эта задача")
    @OneToMany(mappedBy = "id", fetch = FetchType.LAZY)
    private Set<UserProgress> usersTasks = new HashSet<>();

    @Schema(description = "Название")
    @Column(name = "name")
    private String name;

    @Schema(description = "Описание задачи - условие")
    @Column(name = "description")
    private String description;

    @Schema(description = "Ссылка на эталонный репозиторий")
    @Column(name = "url")
    private String url;

    @Schema(description = "Видимость для пользователй")
    @Column(name = "visibility")
    boolean visibilityToUsers;
}
