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
@Table(name = "halls")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Hall {
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "hall_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private HallTypeEnum hallType;

    @Column(name = "hall_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private HallStatusEnum hallStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cinema_id", nullable = false)
    private Cinema cinema;

    @OneToMany(mappedBy = "hall", cascade = CascadeType.ALL)
    private List<Seat> seats = new ArrayList<>();

    @OneToMany(mappedBy = "hall", cascade = CascadeType.ALL)
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
        Hall hall = (Hall) o;
        return Objects.equals(id, hall.id) && Objects.equals(name, hall.name) && hallType == hall.hallType && hallStatus == hall.hallStatus && Objects.equals(createdAt, hall.createdAt) && Objects.equals(updatedAt, hall.updatedAt) && Objects.equals(comment, hall.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, hallType, hallStatus, createdAt, updatedAt, comment);
    }
}
