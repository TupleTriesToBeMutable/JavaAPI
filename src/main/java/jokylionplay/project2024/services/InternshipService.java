package jokylionplay.project2024.services;

import jokylionplay.project2024.dto.InternshipInfoDTO;
import jokylionplay.project2024.dto.LessonTasksDTO;
import jokylionplay.project2024.entities.Internship;
import jokylionplay.project2024.mappers.InternshipMapper;
import jokylionplay.project2024.mappers.LessonMapper;
import jokylionplay.project2024.repository.InternshipRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
        {
            internshipRepository.deleteById(internshipId);
            internshipRepository.flush();
        }
        else throw new IllegalArgumentException("Deleting : Internship doesn`t exist");
    }

    public void update(InternshipInfoDTO dto) throws IllegalArgumentException{
        Optional<Internship> internship = internshipRepository.findById(dto.getId());
        if(internship.isEmpty())
            throw new IllegalArgumentException("Updating : Internship doesn`t exist");
        else
        {
            InternshipMapper.MAPPER.updateEntityInfo(dto, internship.get());
            internshipRepository.flush();
        }
    }

    public List<InternshipInfoDTO> getAll(){
        return InternshipMapper.MAPPER.toInfoDTOList(internshipRepository.findAll());
    }

    public List<LessonTasksDTO> findLessonsRelatedWithInternship(Long internshipId){
        Optional<Internship> internship = internshipRepository.findById(internshipId);
        if(internship.isPresent())
            return LessonMapper.MAPPER.toDTOList(internship.get().getLessons());
        else
            return null;
    }
}
