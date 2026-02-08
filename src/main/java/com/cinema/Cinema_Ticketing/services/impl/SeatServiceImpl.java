package com.cinema.Cinema_Ticketing.services.impl;

import com.cinema.Cinema_Ticketing.domain.CreateSeatRequest;
import com.cinema.Cinema_Ticketing.domain.entities.Cinema;
import com.cinema.Cinema_Ticketing.domain.entities.Hall;
import com.cinema.Cinema_Ticketing.domain.entities.Seat;
import com.cinema.Cinema_Ticketing.exceptions.CinemaNotFoundException;
import com.cinema.Cinema_Ticketing.exceptions.HallNotFoundException;
import com.cinema.Cinema_Ticketing.repositories.HallRepository;
import com.cinema.Cinema_Ticketing.repositories.SeatRepository;
import com.cinema.Cinema_Ticketing.services.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SeatServiceImpl implements SeatService {

    private final HallRepository hallRepository;
    private final SeatRepository seatRepository;

    @Override
    public Seat createSeat(Hall hall, CreateSeatRequest request) {
        Seat seat = new Seat();
        seat.setRow(request.getRow());
        seat.setNumber(request.getNumber());
        seat.setSeatType(request.getSeatType());
        seat.setHall(hall);
        return seatRepository.save(seat);
    }

    @Override
    public List<Seat> createSeats(Hall hall, List<CreateSeatRequest> seatRequests) {
        if (seatRequests == null) {
            return Collections.emptyList();
        }
        return seatRequests.stream()
                .map(request -> {
                    Seat seat = new Seat();
                    seat.setRow(request.getRow());
                    seat.setNumber(request.getNumber());
                    seat.setSeatType(request.getSeatType());
                    seat.setHall(hall);
                    return seat;
                })
                .toList();
    }

    @Override
    public Seat addSeatToHall(UUID hallId, CreateSeatRequest request) {
        Hall hall = hallRepository.findById(hallId)
                .orElseThrow(() -> new HallNotFoundException(hallId));
        Seat seat = createSeat(hall, request);
        hall.getSeats().add(seat);
        return seat;
    }
}
