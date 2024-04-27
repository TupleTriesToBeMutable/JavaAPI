package jokylionplay.project2024.mappers;


import jokylionplay.project2024.dto.TaskDTO;
import jokylionplay.project2024.entities.Task;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TaskMapper {
    TaskMapper MAPPER = Mappers.getMapper(TaskMapper.class );

    TaskDTO toDTO(Task s);

    Task toEntity(TaskDTO s);
}
