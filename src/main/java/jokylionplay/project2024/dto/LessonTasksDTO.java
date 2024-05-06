package jokylionplay.project2024.dto;

import jokylionplay.project2024.entities.Task;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collection;

@Data
@AllArgsConstructor
public class LessonTasksDTO {

    private Long id;

    private Collection<TaskInfoDTO> tasks;

    private String name;
}
