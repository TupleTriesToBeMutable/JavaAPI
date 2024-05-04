package jokylionplay.project2024.services;

import jokylionplay.project2024.dto.InternshipInfoDTO;
import jokylionplay.project2024.entities.Internship;
import jokylionplay.project2024.mappers.InternshipMapper;
import jokylionplay.project2024.repository.InternshipRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class InternshipService {

    @Autowired
    private InternshipRepository internshipRepository;

    public InternshipInfoDTO create(InternshipInfoDTO dto){
        Internship internship = InternshipMapper.MAPPER.toEntity(dto);
        internship = internshipRepository.save(internship);
        return InternshipMapper.MAPPER.toInfoDTO(internship);
    }

    public void delete(Long internshipId) throws IllegalArgumentException{
        if(internshipRepository.existsById(internshipId))
            throw new IllegalArgumentException("Deleting : Internship doesn`t exist");
        else
            internshipRepository.deleteById(internshipId);
    }

    public void update(InternshipInfoDTO dto) throws IllegalArgumentException{
        Optional<Internship> internship = internshipRepository.findById(dto.getId());
        if(internship.isEmpty())
            throw new IllegalArgumentException("Updating : Internship doesn`t exist");
        else
            InternshipMapper.MAPPER.updateEntityInfo(dto, internship.get());
    }
}
