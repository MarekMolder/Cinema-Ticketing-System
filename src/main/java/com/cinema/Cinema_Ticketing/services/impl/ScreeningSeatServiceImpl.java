package com.cinema.Cinema_Ticketing.services.impl;

import com.cinema.Cinema_Ticketing.domain.createRequests.CreateScreeningSeatRequest;
import com.cinema.Cinema_Ticketing.domain.entities.Screening;
import com.cinema.Cinema_Ticketing.domain.entities.ScreeningSeat;
import com.cinema.Cinema_Ticketing.domain.entities.ScreeningSeatStatusEnum;
import com.cinema.Cinema_Ticketing.domain.entities.Seat;
import com.cinema.Cinema_Ticketing.exceptions.CinemaTicketException;
import com.cinema.Cinema_Ticketing.exceptions.ScreeningNotFoundException;
import com.cinema.Cinema_Ticketing.exceptions.SeatNotFoundException;
import com.cinema.Cinema_Ticketing.repositories.ScreeningRepository;
import com.cinema.Cinema_Ticketing.repositories.ScreeningSeatRepository;
import com.cinema.Cinema_Ticketing.repositories.SeatRepository;
import com.cinema.Cinema_Ticketing.services.ScreeningSeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ScreeningSeatServiceImpl implements ScreeningSeatService {

    private final ScreeningRepository screeningRepository;
    private final ScreeningSeatRepository screeningSeatRepository;
    private final SeatRepository seatRepository;

    @Override
    public List<ScreeningSeat> createScreeningSeats(Screening screening, List<Seat> seats) {
        List<ScreeningSeat> screeningSeats = new ArrayList<>();
        for (Seat seat : seats) {
            ScreeningSeat screeningSeat = new ScreeningSeat();
            screeningSeat.setScreeningSeatStatus(ScreeningSeatStatusEnum.AVAILABLE);
            screeningSeat.setHeldUntil(screening.getStartAt());
            screeningSeat.setSeat(seat);
            screeningSeat.setScreening(screening);
            screeningSeats.add(screeningSeat);
        }
        return screeningSeats;
    }

    @Override
    public ScreeningSeat addScreeningSeatToScreening(UUID screeningId, CreateScreeningSeatRequest request) {
        Screening screening = screeningRepository.findById(screeningId)
                .orElseThrow(() -> new ScreeningNotFoundException(screeningId));

        Seat seat = seatRepository.findById(request.getSeatId())
                .orElseThrow(() -> new SeatNotFoundException(request.getSeatId()));

        if (!seat.getHall().getId().equals(screening.getHall().getId())) {
            throw new CinemaTicketException("Seat does not belong to the screening's hall");
        }

        ScreeningSeat screeningSeat = new ScreeningSeat();
        screeningSeat.setScreeningSeatStatus(request.getScreeningSeatStatus());
        screeningSeat.setHeldUntil(request.getHeldUntil());
        screeningSeat.setSeat(seat);
        screeningSeat.setScreening(screening);

        screeningSeat = screeningSeatRepository.save(screeningSeat);
        screening.getScreeningSeats().add(screeningSeat);

        return screeningSeat;
    }
}
