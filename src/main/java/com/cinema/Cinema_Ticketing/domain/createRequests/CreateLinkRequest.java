package com.cinema.Cinema_Ticketing.domain.createRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateLinkRequest {
    private String name;
    private String url;
}
