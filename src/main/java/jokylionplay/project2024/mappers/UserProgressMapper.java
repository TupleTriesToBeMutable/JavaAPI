package jokylionplay.project2024.mappers;

import jokylionplay.project2024.dto.UserProgressDTO;
import jokylionplay.project2024.entities.UserProgress;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserProgressMapper {

    UserProgressMapper MAPPER = Mappers.getMapper(UserProgressMapper.class );

    UserProgressDTO toDTO(UserProgress s);

    UserProgress toEntity(UserProgressDTO s);
}
