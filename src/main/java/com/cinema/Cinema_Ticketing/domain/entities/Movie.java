package com.cinema.Cinema_Ticketing.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "movies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie {
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false, length = 500)
    private String description;

    @Column(name = "age_rating", nullable = false)
    private Integer ageRating;

    @Column(name = "movie_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private MovieTypeEnum movieType;

    @Column(name = "duration_min", nullable = false)
    private Integer durationMin;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.PERSIST)
    private Set<Link> links = new HashSet<>();

    @OneToMany(mappedBy = "movie")
    private List<Screening> screenings = new ArrayList<>();

    @CreatedDate
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "comment", length = 500)
    private String comment;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id) && Objects.equals(name, movie.name) && Objects.equals(description, movie.description) && Objects.equals(ageRating, movie.ageRating) && movieType == movie.movieType && Objects.equals(durationMin, movie.durationMin) && Objects.equals(createdAt, movie.createdAt) && Objects.equals(updatedAt, movie.updatedAt) && Objects.equals(comment, movie.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, ageRating, movieType, durationMin, createdAt, updatedAt, comment);
    }
}
