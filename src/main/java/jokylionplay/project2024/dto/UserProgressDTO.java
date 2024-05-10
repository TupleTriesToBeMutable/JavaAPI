package jokylionplay.project2024.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jokylionplay.project2024.entities.Task;
import jokylionplay.project2024.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Schema(description = "Запись о прогрессе пользователя в задаче")
@Data
@AllArgsConstructor
public class UserProgressDTO {

    private String name;

    private String description;

    private boolean status;

    private String comment;
}
