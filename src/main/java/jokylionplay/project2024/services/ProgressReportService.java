package jokylionplay.project2024.services;

import jokylionplay.project2024.dto.UserProgressDTO;
import jokylionplay.project2024.mappers.UserProgressMapper;
import jokylionplay.project2024.repository.InternshipRepository;
import jokylionplay.project2024.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Для одного студента прогресс по курсу и для всех на курсе
 */
@Service
@AllArgsConstructor
public class ProgressReportService {

    @Autowired
    InternshipRepository internshipRepository;

    @Autowired
    UserRepository userRepository;

    public List<UserProgressDTO> getReportByInternshipIdAndUserId(Long internshipId, Long userId) throws IllegalArgumentException{
        if (!internshipRepository.existsById(internshipId))
            throw new IllegalArgumentException("Reporting : Intenship dosn`t exist");
        if(!userRepository.existsById(userId))
            throw new IllegalArgumentException("Reporting : User dosn`t exist");
        List<Object[]> result = userRepository.getReportByInternshipIdAndUserId(internshipId, userId);
        return UserProgressMapper.MAPPER.toDTOFromListObject(result);
    }

}
