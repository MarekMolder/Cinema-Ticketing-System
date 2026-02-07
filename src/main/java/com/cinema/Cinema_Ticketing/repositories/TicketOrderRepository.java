package com.cinema.Cinema_Ticketing.repositories;

import com.cinema.Cinema_Ticketing.domain.entities.TicketOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TicketOrderRepository extends JpaRepository<TicketOrder, UUID> {
}
