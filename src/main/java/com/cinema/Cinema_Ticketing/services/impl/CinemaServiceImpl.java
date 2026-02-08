package com.cinema.Cinema_Ticketing.services.impl;

import com.cinema.Cinema_Ticketing.domain.CreateCinemaRequest;
import com.cinema.Cinema_Ticketing.domain.entities.Cinema;
import com.cinema.Cinema_Ticketing.domain.entities.Hall;
import com.cinema.Cinema_Ticketing.repositories.CinemaRepository;
import com.cinema.Cinema_Ticketing.services.CinemaService;
import com.cinema.Cinema_Ticketing.services.HallService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CinemaServiceImpl implements CinemaService {

    private final CinemaRepository cinemaRepository;
    private final HallService hallService;

    @Override
    public Cinema createCinema(CreateCinemaRequest request) {
        Cinema cinema = new Cinema();
        cinema.setName(request.getName());

        List<Hall> halls = request.getHalls().stream()
                .map(hallRequest -> hallService.createHall(cinema, hallRequest))
                .toList();

        cinema.setHalls(halls);

        return cinemaRepository.save(cinema);
    }
}
