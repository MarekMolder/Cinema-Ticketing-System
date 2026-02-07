package com.cinema.Cinema_Ticketing.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "screening_seats",
        uniqueConstraints = @UniqueConstraint(name="uk_screening_seat", columnNames={"screening_id","seat_id"}))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScreeningSeat {
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "screening_seat_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private ScreeningSeatStatusEnum screeningSeatStatus;

    @Column(name = "held_until", nullable = false)
    private LocalDateTime heldUntil;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seat_id", nullable = false)
    private Seat seat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "screening_id", nullable = false)
    private Screening screening;

    @CreatedDate
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ScreeningSeat that = (ScreeningSeat) o;
        return Objects.equals(id, that.id) && screeningSeatStatus == that.screeningSeatStatus && Objects.equals(heldUntil, that.heldUntil) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, screeningSeatStatus, heldUntil, createdAt, updatedAt);
    }
}
