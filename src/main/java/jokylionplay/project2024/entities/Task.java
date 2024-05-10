package jokylionplay.project2024.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "tasks")
    private Set<Lesson> lessons = new HashSet<>();

    @OneToMany(mappedBy = "id", fetch = FetchType.LAZY)
    private Set<UserProgress> usersTasks = new HashSet<>();

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "url")
    private String url;

    @Column(name = "visibility")
    boolean visibilityToUsers;
}
