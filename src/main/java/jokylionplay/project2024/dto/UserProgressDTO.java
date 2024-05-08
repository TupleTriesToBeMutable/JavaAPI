package jokylionplay.project2024.dto;

import jokylionplay.project2024.entities.Task;
import jokylionplay.project2024.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserProgressDTO {

    private String name;

    private String description;

    private boolean status;

    private String comment;
}
