package jokylionplay.project2024.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaskInfoDTO {
    private Long id;

    private String name;

    private String description;

    private String url;
}
