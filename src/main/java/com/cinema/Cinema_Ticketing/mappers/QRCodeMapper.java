package com.cinema.Cinema_Ticketing.mappers;

import com.cinema.Cinema_Ticketing.domain.createRequests.CreateQRCodeRequest;
import com.cinema.Cinema_Ticketing.domain.dtos.requests.CreateQRCodeRequestDto;
import com.cinema.Cinema_Ticketing.domain.dtos.responses.CreateQRCodeResponseDto;
import com.cinema.Cinema_Ticketing.domain.entities.QRCode;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface QRCodeMapper {

    CreateQRCodeRequest fromDto(CreateQRCodeRequestDto dto);

    CreateQRCodeResponseDto toDto(QRCode qrCode);
}
