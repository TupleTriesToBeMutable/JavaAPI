package jokylionplay.project2024.repository;

import jokylionplay.project2024.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}