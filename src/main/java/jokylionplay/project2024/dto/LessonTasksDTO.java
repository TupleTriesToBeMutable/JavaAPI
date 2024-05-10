package jokylionplay.project2024.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jokylionplay.project2024.entities.Task;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collection;

@Schema(description = "Данные урока и задания входящие в него")
@Data
@AllArgsConstructor
public class LessonTasksDTO {

    private Long id;

    private Collection<TaskInfoDTO> tasks;

    private String name;
}
