package com.cinema.Cinema_Ticketing.mappers;

import com.cinema.Cinema_Ticketing.domain.createRequests.CreateScreeningSeatRequest;
import com.cinema.Cinema_Ticketing.domain.dtos.requests.CreateScreeningSeatRequestDto;
import com.cinema.Cinema_Ticketing.domain.dtos.responses.CreateScreeningSeatResponseDto;
import com.cinema.Cinema_Ticketing.domain.entities.ScreeningSeat;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ScreeningSeatMapper {

    CreateScreeningSeatRequest fromDto(CreateScreeningSeatRequestDto createScreeningSeatRequestDto);

    CreateScreeningSeatResponseDto toDto(ScreeningSeat screeningSeat);
}
