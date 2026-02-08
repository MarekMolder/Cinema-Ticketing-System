package com.cinema.Cinema_Ticketing.mappers;

import com.cinema.Cinema_Ticketing.domain.createRequests.CreateCinemaRequest;
import com.cinema.Cinema_Ticketing.domain.dtos.requests.CreateCinemaRequestDto;
import com.cinema.Cinema_Ticketing.domain.dtos.responses.CreateCinemaResponseDto;
import com.cinema.Cinema_Ticketing.domain.entities.Cinema;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {HallMapper.class})
public interface CinemaMapper {

    CreateCinemaRequest fromDto(CreateCinemaRequestDto dto);

    CreateCinemaResponseDto toDto(Cinema cinema);
}
