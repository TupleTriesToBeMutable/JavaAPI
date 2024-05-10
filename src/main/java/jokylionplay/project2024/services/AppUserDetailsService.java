package jokylionplay.project2024.services;

import jokylionplay.project2024.entities.Admin;
import jokylionplay.project2024.entities.User;
import jokylionplay.project2024.repository.AdminRepository;
import jokylionplay.project2024.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Сервис для работы с Spring Security
 */
@Component
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AdminRepository adminRepository;

    /**
     * Создание UserDetails по username
     * @param username the username identifying the user whose data is required
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        Admin admin = adminRepository.findByLogin(username);

        if(user == null && admin == null)
            throw new UsernameNotFoundException("Not found");

        List<SimpleGrantedAuthority> authorities = List.of(
                new SimpleGrantedAuthority(
                        admin == null ? "USER" : "ADMIN"));

        if(admin == null)
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
        else
            return new org.springframework.security.core.userdetails.User(admin.getLogin(), admin.getPassword(), authorities);
    }
}
