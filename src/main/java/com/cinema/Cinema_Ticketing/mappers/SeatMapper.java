package com.cinema.Cinema_Ticketing.mappers;

import com.cinema.Cinema_Ticketing.domain.createRequests.CreateSeatRequest;
import com.cinema.Cinema_Ticketing.domain.dtos.requests.CreateSeatRequestDto;
import com.cinema.Cinema_Ticketing.domain.dtos.responses.CreateSeatResponseDto;
import com.cinema.Cinema_Ticketing.domain.entities.Seat;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SeatMapper {

    CreateSeatRequest fromDto(CreateSeatRequestDto dto);

    CreateSeatResponseDto toDto(Seat seat);
}
