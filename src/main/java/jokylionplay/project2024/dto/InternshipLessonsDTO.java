package jokylionplay.project2024.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;
import java.util.Collection;
@Schema(description = "Данные стажировки вместе с уроками")
@Data
@AllArgsConstructor
public class InternshipLessonsDTO {

    private Long id;

    @Schema(description = "Список уроков")
    private Collection<LessonTasksDTO> lessons;

    private String name;

    private Date startDate;

    private Date endDate;

    private Date registrationEnd;

    private boolean status;
}
