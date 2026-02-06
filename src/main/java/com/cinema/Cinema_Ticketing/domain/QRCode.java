package com.cinema.Cinema_Ticketing.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "qr_codes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QRCode {
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "code_value", nullable = false)
    private String codeValue;

    @Column(name = "code_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private CodeStatusEnum codeStatus;

    @OneToOne(mappedBy = "QRCode", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
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
        QRCode qrCode = (QRCode) o;
        return Objects.equals(id, qrCode.id) && Objects.equals(codeValue, qrCode.codeValue) && codeStatus == qrCode.codeStatus && Objects.equals(createdAt, qrCode.createdAt) && Objects.equals(updatedAt, qrCode.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codeValue, codeStatus, createdAt, updatedAt);
    }
}
