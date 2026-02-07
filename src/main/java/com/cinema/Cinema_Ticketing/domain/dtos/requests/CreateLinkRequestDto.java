package com.cinema.Cinema_Ticketing.domain.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateLinkRequestDto {

    @NotBlank(message = "Link name is required")
    private String name;

    @NotBlank(message = "Link url is required")
    private String url;
}
