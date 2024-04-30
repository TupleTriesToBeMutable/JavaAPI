package jokylionplay.project2024.services;

import jokylionplay.project2024.dto.UserDTO;
import jokylionplay.project2024.entities.Internship;
import jokylionplay.project2024.entities.User;
import jokylionplay.project2024.mappers.UserMapper;
import jokylionplay.project2024.repository.InternshipRepository;
import jokylionplay.project2024.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RegistrationService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private InternshipRepository internshipRepository;

    public UserDTO userRegistration(UserDTO dto){
        User user = UserMapper.MAPPER.toEntity(dto);
        user = userRepository.save(user);
        return UserMapper.MAPPER.toDTO(user);
    }

    /**
     *
     * @param intershipId
     * @param userId
     * @return
     * Дописать с try и разные ошибки, что нет стадировки такой или такого пользователя
     */
    public boolean internshipRegistration(Long intershipId, Long userId){
        Optional<User> user = userRepository.findById(userId);
        Optional<Internship> internship = internshipRepository.findById(intershipId);

        boolean isDone = true;
        if(user.isPresent() && internship.isPresent())
        {
            internship.get().getUsers().add(user.get());
        }
        else
            isDone = false;

        return isDone;
    }
}
