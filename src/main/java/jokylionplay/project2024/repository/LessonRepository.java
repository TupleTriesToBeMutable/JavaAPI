package jokylionplay.project2024.repository;

import jokylionplay.project2024.entities.Lesson;
import jokylionplay.project2024.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface  LessonRepository extends JpaRepository<Lesson, Long> {
    /**
     * Получение задач которые входят в урок
     * @param lessonId id урока
     * @return список задач
     */
    @Modifying
    @Query(value = "select * " +
            "from lessons_tasks " +
            "join tasks " +
            "on lessons_tasks.lesson_id = lessons.id " +
            "where lessons.id = :lessonId",
            nativeQuery = true)
    List<Task> findAllRelatedTasks(Long lessonId);
}