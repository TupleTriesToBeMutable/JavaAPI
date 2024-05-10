package jokylionplay.project2024.mappers;

import jokylionplay.project2024.dto.InternshipInfoDTO;
import jokylionplay.project2024.dto.InternshipLessonsDTO;
import jokylionplay.project2024.dto.InternshipUsersDTO;
import jokylionplay.project2024.entities.Internship;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("session")
@Mapper
public interface InternshipMapper {

    InternshipMapper MAPPER = Mappers.getMapper(InternshipMapper.class );

    @Mapping(source = "users", target = "users")
    InternshipUsersDTO toInternshipUsersDTO(Internship s);

    @Mapping(source = "lessons", target = "lessons")
    InternshipLessonsDTO toInternshipLessonsDTO(Internship s);
    
    InternshipInfoDTO toInfoDTO(Internship s);

    Internship toEntity(InternshipInfoDTO s);

    /**
     *
     * @param info данные для изменения
     * @param relationships entity данные, которого нужно обновить
     */
    void updateEntityInfo(InternshipInfoDTO info, @MappingTarget Internship relationships);

    /**
     * Преобзарование списка объектов в DTO
     * @param s
     * @return список DTO
     */
    List<InternshipInfoDTO> toInfoDTOList(List<Internship> s);

    List<InternshipLessonsDTO> toInternshipLessonsDTOList(List<Internship> s);
}