package com.cinema.Cinema_Ticketing.mappers;

import com.cinema.Cinema_Ticketing.domain.CreateMovieRequest;
import com.cinema.Cinema_Ticketing.domain.dtos.requests.CreateMovieRequestDto;
import com.cinema.Cinema_Ticketing.domain.dtos.responses.CreateMovieResponseDto;
import com.cinema.Cinema_Ticketing.domain.entities.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MovieMapper {

    CreateMovieRequest fromDto(CreateMovieRequestDto dto);

    CreateMovieResponseDto toDto(Movie movie);
}
