package com.cinema.Cinema_Ticketing.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "ticket_validations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketValidation {
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "validated_at", nullable = false)
    private LocalDateTime validatedAt;

    @Column(name = "method", nullable = false)
    @Enumerated(EnumType.STRING)
    private MethodEnum method;

    @Column(name = "result", nullable = false)
    @Enumerated(EnumType.STRING)
    private ResultEnum result;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_id", nullable = false)
    private Ticket ticket;

    @CreatedDate
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TicketValidation that = (TicketValidation) o;
        return Objects.equals(id, that.id) && Objects.equals(validatedAt, that.validatedAt) && method == that.method && result == that.result && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, validatedAt, method, result, createdAt, updatedAt);
    }
}
