package jokylionplay.project2024.services;

import jakarta.persistence.EntityManager;
import jokylionplay.project2024.dto.LessonInfoDTO;
import jokylionplay.project2024.dto.LessonTasksDTO;
import jokylionplay.project2024.entities.Internship;
import jokylionplay.project2024.entities.Lesson;
import jokylionplay.project2024.mappers.LessonMapper;
import jokylionplay.project2024.repository.InternshipRepository;
import jokylionplay.project2024.repository.LessonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Добавление, удаление, обновление, прикрепление к курсу
 */
@Service
@AllArgsConstructor
public class LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private InternshipRepository internshipRepository;

    public LessonInfoDTO create(LessonInfoDTO dto){
        Lesson lesson = LessonMapper.MAPPER.toEntity(dto);
        Lesson saved = lessonRepository.save(lesson);
        return LessonMapper.MAPPER.toInfoDTO(saved);
    }

    public void delete(Long lessonId) throws IllegalArgumentException{
        if(lessonRepository.existsById(lessonId))
        {
            lessonRepository.deleteById(lessonId);
            lessonRepository.flush();
        }
        else
            throw new IllegalArgumentException("Deleting : Lesson doesn`t exist");
    }

    public void update(LessonInfoDTO dto) throws IllegalArgumentException{
        Optional<Lesson> lesson = lessonRepository.findById(dto.getId());
        if(lesson.isEmpty())
            throw new IllegalArgumentException("Updating : Lesson doesn`t exist");
        else
        {
            LessonMapper.MAPPER.updateEntityInfo(dto, lesson.get());
            lessonRepository.flush();
        }
    }

    public void addToInternship(Long lessonId, Long internshipId){
        Optional<Lesson> lesson = lessonRepository.findById(lessonId);
        Optional<Internship> internship = internshipRepository.findById(internshipId);

        if(lesson.isEmpty())
            throw new IllegalArgumentException("Adding lesson to Intership : The lesson does not exist");

        if(internship.isEmpty())
            throw new IllegalArgumentException("Adding lesson to Intership : The internship does not exist");

        Collection<Lesson> lessons = internship.get().getLessons();
        if(lessons.contains(lesson.get()))
            throw new IllegalArgumentException("The lesson has already registered for an internship");

        lessons.add(lesson.get());
        internshipRepository.flush();
    }

    /**
     * Проверить работает ли удаление. если убрать из одной коллекции
     * @param lessonId
     * @param internshipId
     */
    public void removeFromInternship(Long lessonId, Long internshipId){
        Optional<Lesson> lesson = lessonRepository.findById(lessonId);
        Optional<Internship> internship = internshipRepository.findById(internshipId);

        if(lesson.isEmpty())
            throw new IllegalArgumentException("Removing lesson from Intership : The lesson does not exist");

        if(internship.isEmpty())
            throw new IllegalArgumentException("Removing lesson from Intership : The internship does not exist");

        internship.get().getLessons().remove(lesson.get());
        internshipRepository.flush();

    }
}
