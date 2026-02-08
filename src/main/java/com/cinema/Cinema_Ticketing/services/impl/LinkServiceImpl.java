package com.cinema.Cinema_Ticketing.services.impl;

import com.cinema.Cinema_Ticketing.domain.createRequests.CreateLinkRequest;
import com.cinema.Cinema_Ticketing.domain.entities.Link;
import com.cinema.Cinema_Ticketing.domain.entities.Movie;
import com.cinema.Cinema_Ticketing.exceptions.MovieNotFoundException;
import com.cinema.Cinema_Ticketing.repositories.LinkRepository;
import com.cinema.Cinema_Ticketing.repositories.MovieRepository;
import com.cinema.Cinema_Ticketing.services.LinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LinkServiceImpl implements LinkService {

    private final LinkRepository linkRepository;
    private final MovieRepository movieRepository;

    @Override
    public Link createLink(Movie movie, CreateLinkRequest request) {
        Link link = new Link();
        link.setName(request.getName());
        link.setUrl(request.getUrl());
        link.setMovie(movie);
        return linkRepository.save(link);
    }

    @Override
    public Set<Link> createLinks(Movie movie, Set<CreateLinkRequest> linkRequests) {
        if (linkRequests == null) {
            return Collections.emptySet();
        }

        return linkRequests.stream()
                .map(request -> {
                    Link link = new Link();
                    link.setName(request.getName());
                    link.setUrl(request.getUrl());
                    link.setMovie(movie);
                    return link;
                })
                .collect(Collectors.toSet());
    }

    @Override
    public Link addLinkToMovie(UUID movieId, CreateLinkRequest createLinkRequest) {
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new MovieNotFoundException(movieId));

        Link link = createLink(movie, createLinkRequest);
        movie.getLinks().add(link);
        return link;
    }
}
