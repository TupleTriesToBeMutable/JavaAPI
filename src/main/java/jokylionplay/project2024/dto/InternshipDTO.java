package jokylionplay.project2024.dto;

import jokylionplay.project2024.entities.Lesson;
import jokylionplay.project2024.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.Collection;

@Data
@AllArgsConstructor
public class InternshipDTO {
    
    private Long id;

    private String name;

    private Date startDate;

    private Date endDate;

    private Date registrationEnd;

    private boolean status;
}
