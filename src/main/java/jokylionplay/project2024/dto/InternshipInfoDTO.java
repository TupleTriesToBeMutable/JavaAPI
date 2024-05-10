package jokylionplay.project2024.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;

@Schema(description = "Информация о стажировке")
@Data
@AllArgsConstructor
public class InternshipInfoDTO {

    @Schema(description = "ID")
    private Long id;

    @Schema(description = "Навзание")
    private String name;

    @Schema(description = "Дата начала")
    private Date startDate;

    @Schema(description = "Дата окончания")
    private Date endDate;

    @Schema(description = "Дата конца регистрации")
    private Date registrationEnd;

    @Schema(description = "Статус")
    private boolean status;
}
