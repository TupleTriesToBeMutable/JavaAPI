package jokylionplay.project2024.repository;

import jokylionplay.project2024.entities.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface  LessonRepository extends JpaRepository<Lesson, Long> { }