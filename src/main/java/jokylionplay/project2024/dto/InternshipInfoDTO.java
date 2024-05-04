package jokylionplay.project2024.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.sql.Date;

@Data
@AllArgsConstructor
public class InternshipInfoDTO {

    private Long id;

    private String name;

    private Date startDate;

    private Date endDate;

    private Date registrationEnd;

    private boolean status;
}
