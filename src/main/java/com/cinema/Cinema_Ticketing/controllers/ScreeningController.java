package com.cinema.Cinema_Ticketing.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/halls/{hallId}/screenings")
@RequiredArgsConstructor
public class ScreeningController {
}
