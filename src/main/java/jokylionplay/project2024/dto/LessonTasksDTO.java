package jokylionplay.project2024.dto;

import jakarta.persistence.*;
import jokylionplay.project2024.entities.Internship;
import jokylionplay.project2024.entities.Task;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collection;

@Data
@AllArgsConstructor
public class LessonTasksDTO {

    private Long id;

    private Collection<Task> tasks;

    private String name;
}
