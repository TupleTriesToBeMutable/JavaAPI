package jokylionplay.project2024.mappers;

import jokylionplay.project2024.dto.LessonTasksDTO;
import jokylionplay.project2024.entities.Lesson;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope("session")
@Mapper
public interface LessonMapper {

    LessonMapper MAPPER = Mappers.getMapper(LessonMapper.class );

    LessonTasksDTO toDTO(Lesson s);

    Lesson toEntity(LessonTasksDTO s);
}