package com.cinema.Cinema_Ticketing.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "screenings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Screening {
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "start_at", nullable = false)
    private LocalDateTime startAt;

    @Column(name = "end_at", nullable = false)
    private LocalDateTime endAt;

    @Column(name = "screening_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private ScreeningStatusEnum screeningStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hall_id", nullable = false)
    private Hall hall;

    @OneToMany(mappedBy = "screening", cascade = CascadeType.ALL)
    private List<TicketOrder> ticketOrders = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    @CreatedDate
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Screening screening = (Screening) o;
        return Objects.equals(id, screening.id) && Objects.equals(name, screening.name) && Objects.equals(startAt, screening.startAt) && Objects.equals(endAt, screening.endAt) && screeningStatus == screening.screeningStatus && Objects.equals(createdAt, screening.createdAt) && Objects.equals(updatedAt, screening.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, startAt, endAt, screeningStatus, createdAt, updatedAt);
    }
}
