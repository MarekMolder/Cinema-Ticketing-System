package com.cinema.Cinema_Ticketing.repositories;

import com.cinema.Cinema_Ticketing.domain.entities.QRCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface QRCodeRepository extends JpaRepository<QRCode, UUID> {
}
