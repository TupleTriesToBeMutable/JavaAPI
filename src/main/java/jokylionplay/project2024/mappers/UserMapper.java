package jokylionplay.project2024.mappers;

import jokylionplay.project2024.dto.UserDTO;
import jokylionplay.project2024.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
@Mapper
public interface UserMapper {
    UserMapper MAPPER = Mappers.getMapper(UserMapper.class );

    UserDTO toDTO(User s);

    User toEntity(UserDTO s);
}
