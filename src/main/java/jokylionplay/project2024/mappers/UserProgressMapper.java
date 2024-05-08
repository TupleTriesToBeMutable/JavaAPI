package jokylionplay.project2024.mappers;

import jokylionplay.project2024.dto.AllUsersProgress;
import jokylionplay.project2024.dto.UserProgressDTO;
import jokylionplay.project2024.entities.UserProgress;
import org.mapstruct.Mapper;
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

    default UserProgressDTO toUserProgressDTOFromListObject(Object[] s){
        return new UserProgressDTO(
                (String) s[0],
                (String) s[1],
                (Boolean) s[2],
                (String) s[3]);
    }
    List<UserProgressDTO> toUserProgressDTOFromListObject(List<Object[]> s);

    default AllUsersProgress toAllUsersProgressFromObject(Object[] s){
        return new AllUsersProgress(
                (String) s[0],
                (String) s[1],
                (boolean) s[2]);
    }

    List<AllUsersProgress> toAllUsersProgressFromListObject(List<Object[]> s);
}