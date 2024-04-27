package jokylionplay.project2024.dto;

import jakarta.persistence.*;
import jokylionplay.project2024.entities.Task;
import jokylionplay.project2024.entities.User;

public class UserProgressDTO {

    private Long id;

    private User user;

    private Task task;

    private boolean status;

    private String comment;
}
