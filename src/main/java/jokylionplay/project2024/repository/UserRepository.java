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
    @Query(value = "select * " +
            "from internships " +
            "join internships_users " +
            "on internships.id = internships_users.internship_id " +
            "where internships_users.user_id = :userId",
            nativeQuery = true)
    List<Internship> findInternshipsRelatedWithUser(Long userId);
}