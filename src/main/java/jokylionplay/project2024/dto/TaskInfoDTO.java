package jokylionplay.project2024.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Schema(description = "Информация о задании")
@Data
@AllArgsConstructor
public class TaskInfoDTO {
    private Long id;

    private String name;

    private String description;

    private String url;
}
