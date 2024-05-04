package jokylionplay.project2024.mappers;

import jokylionplay.project2024.dto.InternshipInfoDTO;
import jokylionplay.project2024.dto.LessonInfoDTO;
import jokylionplay.project2024.dto.LessonTasksDTO;
import jokylionplay.project2024.entities.Internship;
import jokylionplay.project2024.entities.Lesson;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope("session")
@Mapper
public interface LessonMapper {

    LessonMapper MAPPER = Mappers.getMapper(LessonMapper.class );

    LessonTasksDTO toLessonTasksDTO(Lesson s);

    LessonInfoDTO toInfoDTO(Lesson s);

    Lesson toEntity(LessonInfoDTO s);

    void updateEntityInfo(LessonInfoDTO info, @MappingTarget Lesson relationships);
}