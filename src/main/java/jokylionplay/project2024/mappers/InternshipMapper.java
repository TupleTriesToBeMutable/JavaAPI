package jokylionplay.project2024.mappers;

import jokylionplay.project2024.dto.InternshipLessonsDTO;
import jokylionplay.project2024.dto.InternshipUsersDTO;
import jokylionplay.project2024.entities.Internship;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface InternshipMapper {

    InternshipMapper MAPPER = Mappers.getMapper(InternshipMapper.class );

    @Mapping(source = "users", target = "users")
    InternshipUsersDTO toInternshipUsersDTO(Internship s);

    @Mapping(source = "lessons", target = "lessons")
    InternshipLessonsDTO toInternshipLessonsDTO(Internship s);

    Internship toEntity(InternshipUsersDTO s);

    Internship toEntity(InternshipLessonsDTO s);
}