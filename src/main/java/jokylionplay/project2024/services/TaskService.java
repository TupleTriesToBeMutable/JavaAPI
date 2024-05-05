package jokylionplay.project2024.services;

import jokylionplay.project2024.dto.TaskInfoDTO;
import jokylionplay.project2024.entities.Internship;
import jokylionplay.project2024.entities.Lesson;
import jokylionplay.project2024.entities.Task;
import jokylionplay.project2024.mappers.TaskMapper;
import jokylionplay.project2024.repository.LessonRepository;
import jokylionplay.project2024.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Добавление, удаление, обновление, прикрепление к уроку
 */
@Service
@AllArgsConstructor
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private LessonRepository lessonRepository;

    public TaskInfoDTO create(TaskInfoDTO dto){
        Task task = TaskMapper.MAPPER.toEntity(dto);
        Task saved = taskRepository.save(task);
        return TaskMapper.MAPPER.toInfoDTO(saved);
    }

    public void delete(Long taskId) throws IllegalArgumentException{
        if(taskRepository.existsById(taskId))
            taskRepository.deleteById(taskId);
        else
            throw new IllegalArgumentException("Deleting : Task doesn`t exist");
    }

    public void update(TaskInfoDTO dto) throws IllegalArgumentException{
        Optional<Task> task = taskRepository.findById(dto.getId());
        if(task.isEmpty())
            throw new IllegalArgumentException("Updating : Task doesn`t exist");
        else
        {
            TaskMapper.MAPPER.updateEntityInfo(dto, task.get());
            taskRepository.flush();
        }
    }

    public void addToLesson(Long taskId, Long lessonId){
        Optional<Task> task = taskRepository.findById(taskId);
        Optional<Lesson> lesson = lessonRepository.findById(lessonId);

        if(lesson.isEmpty())
            throw new IllegalArgumentException("Lesson to Intership : The lesson does not exist");

        if(task.isEmpty())
            throw new IllegalArgumentException("Lesson to Intership : The task does not exist");

        Collection<Task> tasks = lesson.get().getTasks();
        if(tasks.contains(task.get()))
            throw new IllegalArgumentException("The task has already registered for an task");

        tasks.add(task.get());
        taskRepository.flush();
    }

    public void removeFromLesson(Long taskId, Long lessonId){
        Optional<Lesson> lesson = lessonRepository.findById(lessonId);
        Optional<Task> task = taskRepository.findById(taskId);

        if(lesson.isEmpty())
            throw new IllegalArgumentException("Removing lesson from Intership : The lesson does not exist");

        if(task.isEmpty())
            throw new IllegalArgumentException("Removing lesson from Intership : The task does not exist");

        lesson.get().getTasks().remove(task.get());
        lessonRepository.flush();
    }

    public List<Task> getAllInLesson(){
        return taskRepository.findAll();
    }
}
