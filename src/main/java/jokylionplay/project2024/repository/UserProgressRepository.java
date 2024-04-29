package jokylionplay.project2024.repository;

import jokylionplay.project2024.entities.UserProgress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProgressRepository extends JpaRepository<UserProgress, Long> {
}