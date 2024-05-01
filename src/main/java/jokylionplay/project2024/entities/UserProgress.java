package jokylionplay.project2024.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description = "Прогресс пользователей - выполненние задания")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_progress")
public class UserProgress {
    @Schema(description = "ID записи о состоянии выполнения задач")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "Пользователи у которых есть эта задача")
    @ManyToOne(optional = false, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "user_id")
    private User user;

    @Schema(description = "Задания выданные")
    @ManyToOne(optional = false, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "task_id")
    private Task task;

    @Schema(description = "Статус выполнения, выполнен или нет")
    @Column(name = "status")
    private boolean status;

    @Schema(description = "Комментарий к попытке выполнения задания")
    @Column(name = "comment")
    private String comment;

}
