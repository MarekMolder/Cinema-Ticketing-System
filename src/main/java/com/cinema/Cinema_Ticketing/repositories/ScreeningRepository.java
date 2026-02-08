package com.cinema.Cinema_Ticketing.repositories;

import com.cinema.Cinema_Ticketing.domain.entities.Screening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ScreeningRepository extends JpaRepository<Screening, UUID> {
}
