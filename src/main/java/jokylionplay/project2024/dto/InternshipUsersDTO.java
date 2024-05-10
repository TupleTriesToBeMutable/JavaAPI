package jokylionplay.project2024.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jokylionplay.project2024.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.sql.Date;
import java.util.Collection;
@Schema(description = "Информации я стажировке и стажируемые пользователи")
@Data
@AllArgsConstructor
public class InternshipUsersDTO {

    private Long id;

    @Schema(description = "Список стажируемых")
    private Collection<User> users;

    private String name;

    private Date startDate;

    private Date endDate;

    private Date registrationEnd;

    private boolean status;
}
