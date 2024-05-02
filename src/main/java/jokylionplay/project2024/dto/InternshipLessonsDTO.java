package jokylionplay.project2024.dto;

import jokylionplay.project2024.entities.Lesson;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.sql.Date;
import java.util.Collection;

@Data
@AllArgsConstructor
public class InternshipLessonsDTO {

    private Long id;

    private Collection<Lesson> lessons;

    private String name;

    private Date startDate;

    private Date endDate;

    private Date registrationEnd;

    private boolean status;
}
