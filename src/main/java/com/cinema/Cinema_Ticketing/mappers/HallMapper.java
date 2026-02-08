package com.cinema.Cinema_Ticketing.mappers;

import com.cinema.Cinema_Ticketing.domain.createRequests.CreateHallRequest;
import com.cinema.Cinema_Ticketing.domain.dtos.requests.CreateHallRequestDto;
import com.cinema.Cinema_Ticketing.domain.dtos.responses.CreateHallResponseDto;
import com.cinema.Cinema_Ticketing.domain.entities.Hall;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {SeatMapper.class, ScreeningMapper.class})
public interface HallMapper {

    CreateHallRequest fromDto(CreateHallRequestDto dto);

    CreateHallResponseDto toDto(Hall hall);
}
