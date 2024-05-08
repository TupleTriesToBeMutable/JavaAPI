package jokylionplay.project2024.services;

import jokylionplay.project2024.dto.InternshipLessonsDTO;
import jokylionplay.project2024.dto.UserInfoDTO;
import jokylionplay.project2024.dto.UserProgressDTO;
import jokylionplay.project2024.entities.User;
import jokylionplay.project2024.mappers.InternshipMapper;
import jokylionplay.project2024.mappers.UserMapper;
import jokylionplay.project2024.mappers.UserProgressMapper;
import jokylionplay.project2024.repository.InternshipRepository;
import jokylionplay.project2024.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private InternshipRepository internshipRepository;

    public UserInfoDTO getInfo(Long id) throws IllegalArgumentException{
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty())
            throw new IllegalArgumentException("Getting Info : User doesn`t exist");
        else
            return UserMapper.MAPPER.toInfoDTO(user.get());
    }

    public void update(UserInfoDTO dto) throws IllegalArgumentException{
        Optional<User> user = userRepository.findById(dto.getId());
        if(user.isEmpty())
            throw new IllegalArgumentException("Updating : User doesn`t exist");
        else
        {
            UserMapper.MAPPER.updateEntityInfo(dto, user.get());
            userRepository.flush();
        }
    }

    public List<InternshipLessonsDTO> findInternshipsRelatedWithUser(Long userId){
        Optional<User> user = userRepository.findById(userId);
        if(user.isEmpty())
            throw new IllegalArgumentException("GettingInfo : User doesn`t exist");
        else
            return InternshipMapper.MAPPER.toInternshipLessonsDTOList(userRepository.findInternshipsRelatedWithUser(userId));
    }


    public List<UserProgressDTO> getReportByInternshipIdAndUserId(Long internshipId, Long userId) throws IllegalArgumentException{
        if (!internshipRepository.existsById(internshipId))
            throw new IllegalArgumentException("Reporting : Intenship dosn`t exist");
        if(!userRepository.existsById(userId))
            throw new IllegalArgumentException("Reporting : User dosn`t exist");
        List<Object[]> result = userRepository.getReportByInternshipIdAndUserId(internshipId, userId);
        return UserProgressMapper.MAPPER.toDTOFromListObject(result);
    }
}
