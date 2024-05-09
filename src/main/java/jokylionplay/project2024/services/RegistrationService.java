package jokylionplay.project2024.services;

import jokylionplay.project2024.dto.UserInfoDTO;
import jokylionplay.project2024.entities.Internship;
import jokylionplay.project2024.entities.User;
import jokylionplay.project2024.mappers.UserMapper;
import jokylionplay.project2024.repository.InternshipRepository;
import jokylionplay.project2024.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RegistrationService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private InternshipRepository internshipRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserInfoDTO registration(UserInfoDTO dto){
        String passwordCoded = bCryptPasswordEncoder.encode(dto.getPassword());
        dto.setPassword(passwordCoded);
        User user = UserMapper.MAPPER.toEntity(dto);
        user = userRepository.save(user);
        return UserMapper.MAPPER.toInfoDTO(user);
    }

    public void internshipRegistration(Long internshipId, Long userId) throws IllegalArgumentException{
        Optional<User> user = userRepository.findById(userId);
        Optional<Internship> internship = internshipRepository.findById(internshipId);

        if(user.isEmpty())
            throw new IllegalArgumentException("The user does not exist");

        if(internship.isEmpty())
            throw new IllegalArgumentException("The internship does not exist");

        if(internship.get().getUsers().contains(user.get()))
            throw new IllegalArgumentException("The user has already registered for an internship");

        internship.get().getUsers().add(user.get());
        internshipRepository.flush();
    }
}
