package jokylionplay.project2024.mappers;

import jokylionplay.project2024.dto.LessonTasksDTO;
import jokylionplay.project2024.entities.Lesson;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper
public interface LessonMapper {

    LessonMapper MAPPER = Mappers.getMapper(LessonMapper.class );

    LessonTasksDTO toDTO(Lesson s);

    Lesson toEntity(LessonTasksDTO s);
}