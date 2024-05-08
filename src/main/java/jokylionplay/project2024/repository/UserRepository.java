package jokylionplay.project2024.repository;

import jokylionplay.project2024.entities.Internship;
import jokylionplay.project2024.entities.Lesson;
import jokylionplay.project2024.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Modifying
    @Query(value = "select\n" +
            "internships.id ,\n" +
            "internships.name ,\n" +
            "internships.start_date ,\n" +
            "internships.end_date ,\n" +
            "internships.registration_end,\n" +
            "internships.status\n" +
            "from internships \n" +
            "join internships_users \n" +
            "on internships.id = internships_users.internship_id \n" +
            "where internships_users.user_id = :userId ;",
            nativeQuery = true)
    List<Internship> findInternshipsRelatedWithUser(Long userId);

    @Modifying
    @Query(value = "select \n" +
            "tasks.name,\n" +
            "tasks.description,\n" +
            "user_progress.status,\n" +
            "user_progress.comment\n" +
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
            "where user_progress.user_id = :userId ;",
            nativeQuery = true)
    List<Object[]> getReportByInternshipIdAndUserId(Long internshipId, Long userId);
}