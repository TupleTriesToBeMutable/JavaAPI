package jokylionplay.project2024.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Schema(description = "Прогресс пользователя")
@Data
@AllArgsConstructor
public class AllUsersProgress {

    @Schema(description = "Имя пользователя")
    String username;

    @Schema(description = "Имя задачи")
    String name;

    @Schema(description = "Статус задачи")
    boolean status;
}
