package jokylionplay.project2024.mappers;


import jokylionplay.project2024.dto.TaskInfoDTO;
import jokylionplay.project2024.entities.Task;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("session")
@Mapper
public interface TaskMapper {
    TaskMapper MAPPER = Mappers.getMapper(TaskMapper.class );

    TaskInfoDTO toInfoDTO(Task s);

    Task toEntity(TaskInfoDTO s);

    void updateEntityInfo(TaskInfoDTO info, @MappingTarget Task relationships);

    List<TaskInfoDTO> toDTOList(List<Task> s);
}
