package com.cinema.Cinema_Ticketing.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "links")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Link {
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "url", nullable = false)
    private String url;

    @ManyToMany(mappedBy = "links", fetch = FetchType.LAZY)
    private Set<Movie> movies = new HashSet<>();

    @CreatedDate
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Link link = (Link) o;
        return Objects.equals(id, link.id) && Objects.equals(name, link.name) && Objects.equals(url, link.url) && Objects.equals(createdAt, link.createdAt) && Objects.equals(updatedAt, link.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, url, createdAt, updatedAt);
    }
}
