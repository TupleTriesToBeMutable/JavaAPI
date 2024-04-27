package jokylionplay.project2024.repository;

import jokylionplay.project2024.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
