package com.cinema.Cinema_Ticketing.domain.createRequests;

import com.cinema.Cinema_Ticketing.domain.entities.CodeStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateQRCodeRequest {
    private String codeValue;
    private CodeStatusEnum codeStatus;
}
