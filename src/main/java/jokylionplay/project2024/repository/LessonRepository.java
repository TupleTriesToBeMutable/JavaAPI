package jokylionplay.project2024.repository;

import jokylionplay.project2024.entities.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  LessonRepository extends JpaRepository<Lesson, Long> {
}