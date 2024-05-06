package jokylionplay.project2024.mappers;

import jokylionplay.project2024.dto.InternshipLessonsDTO;
import jokylionplay.project2024.dto.UserInfoDTO;
import jokylionplay.project2024.dto.UserInternships;
import jokylionplay.project2024.dto.UserTasksDTO;
import jokylionplay.project2024.entities.Internship;
import jokylionplay.project2024.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("session")
@Mapper
public interface UserMapper {
    UserMapper MAPPER = Mappers.getMapper(UserMapper.class );

    UserTasksDTO toUserTasksDTO(User s);

    UserInternships toUserInternships(User s);

    UserInfoDTO toInfoDTO(User s);

    User toEntity(UserInfoDTO s);

    void updateEntityInfo(UserInfoDTO info, @MappingTarget User relationships);

}
