package jokylionplay.project2024.mappers;

import jokylionplay.project2024.dto.UserProgressDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserProgress {

    UserProgress MAPPER = Mappers.getMapper(UserProgress.class );

    UserProgressDTO toDTO(UserProgress s);

    UserProgress toEntity(UserProgressDTO s);
}
