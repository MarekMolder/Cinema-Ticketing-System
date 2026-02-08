package com.cinema.Cinema_Ticketing.domain.dtos.requests;

import com.cinema.Cinema_Ticketing.domain.entities.CodeStatusEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateQRCodeRequestDto {

    @NotBlank(message = "QR Code value is required")
    private String codeValue;

    @NotNull(message = "QR Code status is required")
    private CodeStatusEnum codeStatus;
}
