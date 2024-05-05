package jokylionplay.project2024.repository;

import jokylionplay.project2024.entities.Internship;
import jokylionplay.project2024.entities.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface InternshipRepository extends JpaRepository<Internship, Long> {
    @Modifying
    @Query(value = "select lessons.id, lessons.name, lessons.visibility " +
            "from internships_lessons " +
            "join lessons " +
            "on internships_lessons.lesson_id = lessons.id " +
            "where internships_lessons.internship_id = :internshipId",
            nativeQuery = true)
    List<Lesson> findAllRelatedWithInternship(Long internshipId);
}