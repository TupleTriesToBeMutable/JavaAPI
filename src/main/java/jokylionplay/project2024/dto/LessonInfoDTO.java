package jokylionplay.project2024.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Schema(description = "Данные урока")
@Data
@AllArgsConstructor
public class LessonInfoDTO {

    private Long id;

    private String name;
}
