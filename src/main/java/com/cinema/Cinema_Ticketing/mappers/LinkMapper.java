package com.cinema.Cinema_Ticketing.mappers;

import com.cinema.Cinema_Ticketing.domain.CreateHallRequest;
import com.cinema.Cinema_Ticketing.domain.CreateLinkRequest;
import com.cinema.Cinema_Ticketing.domain.dtos.requests.CreateHallRequestDto;
import com.cinema.Cinema_Ticketing.domain.dtos.requests.CreateLinkRequestDto;
import com.cinema.Cinema_Ticketing.domain.dtos.responses.CreateHallResponseDto;
import com.cinema.Cinema_Ticketing.domain.dtos.responses.CreateLinkResponseDto;
import com.cinema.Cinema_Ticketing.domain.entities.Hall;
import com.cinema.Cinema_Ticketing.domain.entities.Link;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface LinkMapper {

    CreateLinkRequest fromDto(CreateLinkRequestDto dto);

    CreateLinkResponseDto toDto(Link link);
}