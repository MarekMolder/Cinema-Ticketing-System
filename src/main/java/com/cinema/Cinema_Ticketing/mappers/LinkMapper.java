package com.cinema.Cinema_Ticketing.mappers;

import com.cinema.Cinema_Ticketing.domain.createRequests.CreateLinkRequest;
import com.cinema.Cinema_Ticketing.domain.dtos.requests.CreateLinkRequestDto;
import com.cinema.Cinema_Ticketing.domain.dtos.responses.CreateLinkResponseDto;
import com.cinema.Cinema_Ticketing.domain.entities.Link;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface LinkMapper {

    CreateLinkRequest fromDto(CreateLinkRequestDto dto);

    CreateLinkResponseDto toDto(Link link);
}