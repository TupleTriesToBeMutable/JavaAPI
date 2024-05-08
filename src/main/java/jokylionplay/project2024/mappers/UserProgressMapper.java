package jokylionplay.project2024.mappers;

import jokylionplay.project2024.dto.UserProgressDTO;
import jokylionplay.project2024.entities.UserProgress;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("session")
@Mapper
public interface UserProgressMapper {

    UserProgressMapper MAPPER = Mappers.getMapper(UserProgressMapper.class );

    UserProgressDTO toUserProgressDTO(UserProgress s);

    UserProgress toEntity(UserProgressDTO s);

    default UserProgressDTO toDTOfromObject(Object[] s){
        return new UserProgressDTO(
                (String) s[0],
                (String) s[1],
                (Boolean) s[2],
                (String) s[3]);
    }
    List<UserProgressDTO> toDTOFromListObject(List<Object[]> s);
}