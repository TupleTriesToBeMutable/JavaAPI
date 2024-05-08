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
    List<Lesson> findLessonsRelatedWithInternship(Long internshipId);

    @Modifying
    @Query(value = "select \n" +
            "users.username,\n" +
            "tasks.name,\n" +
            "user_progress.status\n" +
            "from user_progress\n" +
            "join(select lessons_tasks.task_id\n" +
            "\t\tfrom lessons_tasks\n" +
            "\t\tjoin (select internships_lessons.lesson_id \n" +
            "\t\t\t\tfrom internships_lessons\n" +
            "\t\t\t\twhere internships_lessons.internship_id = :internshipId ) as need_lesson\n" +
            "\t\ton lessons_tasks.lesson_id = need_lesson.lesson_id) as need_task\n" +
            "on user_progress.task_id = need_task.task_id\n" +
            "join tasks\n" +
            "on user_progress.task_id = tasks.id\n" +
            "join users\n" +
            "on user_progress.user_id = users.id\n" +
            "order by username;",
            nativeQuery = true)
    List<Object[]> getReportForAllUsersByInternshipId(Long internshipId);
}