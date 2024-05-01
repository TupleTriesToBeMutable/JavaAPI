package jokylionplay.project2024.services;

import jokylionplay.project2024.dto.InternshipDTO;
import jokylionplay.project2024.dto.InternshipUsersDTO;
import jokylionplay.project2024.entities.Internship;
import jokylionplay.project2024.entities.Task;
import jokylionplay.project2024.mappers.InternshipMapper;
import jokylionplay.project2024.mappers.TaskMapper;
import jokylionplay.project2024.repository.InternshipRepository;
import jokylionplay.project2024.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class InternshipService {

    @Autowired
    private InternshipRepository repository;

    public InternshipDTO create(InternshipDTO dto){
        Internship internship = InternshipMapper.MAPPER.toEntity(dto);
        internship = repository.save(internship);
        return InternshipMapper.MAPPER.toDTO(internship);
    }

    public void delete(Long internshipId) throws IllegalArgumentException{
        if(repository.existsById(internshipId))
            throw new IllegalArgumentException("Internship doesn`t exist");
        else
            repository.deleteById(internshipId);
    }

    public void update(InternshipDTO dto) throws IllegalArgumentException{
        Optional<Internship> internship = repository.findById(dto.getId());
        if(internship.isEmpty())
            throw new IllegalArgumentException("Internship doesn`t exist");
        else
            InternshipMapper.MAPPER.toEntityWithExistsRelationships(dto, internship.get());
    }
}
