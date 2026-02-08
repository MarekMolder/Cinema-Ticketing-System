package com.cinema.Cinema_Ticketing.services;

import com.cinema.Cinema_Ticketing.domain.createRequests.CreateLinkRequest;
import com.cinema.Cinema_Ticketing.domain.entities.Link;
import com.cinema.Cinema_Ticketing.domain.entities.Movie;

import java.util.Set;
import java.util.UUID;

public interface LinkService {
    Link createLink(Movie movie, CreateLinkRequest request);

    Set<Link> createLinks(Movie movie, Set<CreateLinkRequest> linkRequests);

    Link addLinkToMovie(UUID movieId, CreateLinkRequest createLinkRequest);
}
