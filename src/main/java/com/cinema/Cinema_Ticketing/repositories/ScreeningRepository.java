package com.cinema.Cinema_Ticketing.repositories;

import com.cinema.Cinema_Ticketing.domain.entities.Screening;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ScreeningRepository extends JpaRepository<Screening, UUID> {
}
