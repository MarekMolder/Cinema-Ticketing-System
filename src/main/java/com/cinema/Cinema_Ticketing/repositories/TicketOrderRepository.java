package com.cinema.Cinema_Ticketing.repositories;

import com.cinema.Cinema_Ticketing.domain.entities.TicketOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TicketOrderRepository extends JpaRepository<TicketOrder, UUID> {
    Page<TicketOrder> findByUserId(UUID buyerId, Pageable pageable);
    Page<TicketOrder> findByScreeningId(UUID screeningId, Pageable pageable);
    Optional<TicketOrder> findByIdAndUserId(UUID id, UUID buyerId);
    Optional<TicketOrder> findByIdAndScreeningId(UUID id, UUID screeningId);
    Optional<TicketOrder> findByIdAndUserIdAndScreeningId(UUID id, UUID buyerId, UUID screeningId);
}
