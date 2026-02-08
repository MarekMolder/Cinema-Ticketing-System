package com.cinema.Cinema_Ticketing.controllers;

import com.cinema.Cinema_Ticketing.domain.createRequests.CreateQRCodeRequest;
import com.cinema.Cinema_Ticketing.domain.dtos.requests.CreateQRCodeRequestDto;
import com.cinema.Cinema_Ticketing.domain.dtos.responses.CreateQRCodeResponseDto;
import com.cinema.Cinema_Ticketing.domain.entities.QRCode;
import com.cinema.Cinema_Ticketing.mappers.QRCodeMapper;
import com.cinema.Cinema_Ticketing.services.QRCodeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/tickets/{ticketId}/qr-code")
@RequiredArgsConstructor
public class QRCodeController {

    private final QRCodeMapper qrCodeMapper;
    private final QRCodeService qrCodeService;

    @PostMapping
    public ResponseEntity<CreateQRCodeResponseDto> createQRCode(
            @PathVariable UUID ticketId,
            @Valid @RequestBody CreateQRCodeRequestDto createQRCodeRequestDto) {

        CreateQRCodeRequest createQRCodeRequest = qrCodeMapper.fromDto(createQRCodeRequestDto);

        QRCode createdQRCode = qrCodeService.addQRCodeToTicket(ticketId, createQRCodeRequest);
        CreateQRCodeResponseDto createQRCodeResponseDto = qrCodeMapper.toDto(createdQRCode);

        return new ResponseEntity<>(createQRCodeResponseDto, HttpStatus.CREATED);
    }
}