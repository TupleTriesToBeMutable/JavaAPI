package jokylionplay.project2024.repository;

import jokylionplay.project2024.entities.Admin;
import jokylionplay.project2024.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    /**
     * Поиск пользователей по username
     * @param username
     * @return
     */
    Admin findByLogin(String username);

    /**
     * Получение списка админов
     * @return список админов
     */
    @Query(value = "select * from admins;",
            nativeQuery = true)
    List<Admin> getAll();
}
