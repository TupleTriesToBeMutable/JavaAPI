package jokylionplay.project2024.services;

import jokylionplay.project2024.dto.TaskDTO;
import jokylionplay.project2024.entities.Task;
import jokylionplay.project2024.mappers.TaskMapper;
import jokylionplay.project2024.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TaskService {
    private TaskRepository taskRepository;

    public TaskDTO createTask(TaskDTO dto){
        Task task = TaskMapper.MAPPER.toEntity(dto);
        Task saved = taskRepository.save(task);
        return TaskMapper.MAPPER.toDTO(saved);
    }
}
