package com.cinema.Cinema_Ticketing.mappers;

import com.cinema.Cinema_Ticketing.domain.dtos.responses.CreatedScreeningSeatResponseDto;
import com.cinema.Cinema_Ticketing.domain.entities.ScreeningSeat;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ScreeningSeatMapper {

    CreatedScreeningSeatResponseDto toDto(ScreeningSeat screeningSeat);
}
