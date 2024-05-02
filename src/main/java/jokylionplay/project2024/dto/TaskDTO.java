package jokylionplay.project2024.dto;

import jokylionplay.project2024.entities.Lesson;
import jokylionplay.project2024.entities.UserProgress;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collection;

@Data
@AllArgsConstructor
public class TaskDTO {

    private Long id;

    private Collection<Lesson> lessons;

    private Collection<UserProgress> usersTasks;

    private String name;

    private String description;

    private String url;
}
