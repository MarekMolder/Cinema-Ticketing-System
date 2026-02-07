package com.cinema.Cinema_Ticketing.repositories;

import com.cinema.Cinema_Ticketing.domain.entities.ScreeningSeat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ScreeningSeatRepository extends JpaRepository<ScreeningSeat, UUID> {
}
