package com.cinema.Cinema_Ticketing.controllers;

import com.cinema.Cinema_Ticketing.domain.dtos.detailResponses.GetTicketOrderResponseDto;
import com.cinema.Cinema_Ticketing.domain.dtos.listResponses.ListTicketOrderResponseDto;
import com.cinema.Cinema_Ticketing.domain.dtos.requests.CreateTicketOrderRequestDto;
import com.cinema.Cinema_Ticketing.domain.dtos.responses.CreateTicketOrderResponseDto;
import com.cinema.Cinema_Ticketing.domain.dtos.updateRequest.UpdateTicketOrderRequestDto;
import com.cinema.Cinema_Ticketing.domain.dtos.updateResponse.UpdateTicketOrderResponseDto;
import com.cinema.Cinema_Ticketing.domain.entities.TicketOrder;
import com.cinema.Cinema_Ticketing.domain.createRequests.CreateTicketOrderRequest;
import com.cinema.Cinema_Ticketing.domain.updateRequests.UpdateTicketOrderRequest;
import com.cinema.Cinema_Ticketing.mappers.TicketOrderMapper;
import com.cinema.Cinema_Ticketing.services.TicketOrderService;
import com.cinema.Cinema_Ticketing.util.JwtHelper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1")
@RequiredArgsConstructor
public class TicketOrderController {

    private final TicketOrderMapper ticketOrderMapper;
    private final TicketOrderService ticketOrderService;

    @PostMapping(path = "/screenings/{screeningId}/ticket-orders")
    public ResponseEntity<CreateTicketOrderResponseDto> createTicketOrder(
            @AuthenticationPrincipal Jwt jwt,
            @PathVariable UUID screeningId,
            @Valid @RequestBody CreateTicketOrderRequestDto createTicketOrderRequestDto) {

        UUID userId = JwtHelper.parseUserId(jwt);
        CreateTicketOrderRequest createTicketOrderRequest = ticketOrderMapper.fromDto(createTicketOrderRequestDto);

        TicketOrder createdTicketOrder = ticketOrderService.addTicketOrderToScreening(userId, screeningId, createTicketOrderRequest);
        CreateTicketOrderResponseDto createTicketOrderResponseDto = ticketOrderMapper.toDto(createdTicketOrder);
        return new ResponseEntity<>(createTicketOrderResponseDto, HttpStatus.CREATED);
    }

    @GetMapping(path = "/ticket-orders")
    public ResponseEntity<Page<ListTicketOrderResponseDto>> listTicketOrders(
            @AuthenticationPrincipal Jwt jwt, Pageable pageable) {
        UUID userId = JwtHelper.parseUserId(jwt);
        boolean isManager = JwtHelper.hasRole(jwt, "MANAGER");

        Page<TicketOrder> orders = isManager
                ? ticketOrderService.listTicketOrders(pageable)
                : ticketOrderService.listTicketOrdersForBuyer(userId, pageable);

        return ResponseEntity.ok(orders.map(ticketOrderMapper::toListTicketOrderResponseDto));
    }

    @GetMapping(path = "/screenings/{screeningId}/ticket-orders")
    public ResponseEntity<Page<ListTicketOrderResponseDto>> listTicketOrdersForScreening(
            @AuthenticationPrincipal Jwt jwt,
            @PathVariable UUID screeningId,
            Pageable pageable) {
        if (!JwtHelper.hasRole(jwt, "MANAGER")) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        Page<TicketOrder> ticketOrders = ticketOrderService.listTicketOrdersForScreening(screeningId, pageable);
        return ResponseEntity.ok(ticketOrders.map(ticketOrderMapper::toListTicketOrderResponseDto));
    }

    @GetMapping(path = "/ticket-orders/{ticketOrderId}")
    public ResponseEntity<GetTicketOrderResponseDto> getTicketOrder(
            @AuthenticationPrincipal Jwt jwt,
            @PathVariable UUID ticketOrderId) {
        UUID userId = JwtHelper.parseUserId(jwt);
        boolean isManager = JwtHelper.hasRole(jwt, "MANAGER");

        Optional<TicketOrder> order = isManager
                ? ticketOrderService.getTicketOrder(ticketOrderId)
                : ticketOrderService.getTicketOrderForBuyer(ticketOrderId, userId);

        return order
                .map(ticketOrderMapper::toGetTicketOrderResponseDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(path = "/screenings/{screeningId}/ticket-orders/{ticketOrderId}")
    public ResponseEntity<GetTicketOrderResponseDto> getTicketOrderForScreening(
            @AuthenticationPrincipal Jwt jwt,
            @PathVariable UUID screeningId,
            @PathVariable UUID ticketOrderId) {
        UUID userId = JwtHelper.parseUserId(jwt);
        boolean isManager = JwtHelper.hasRole(jwt, "MANAGER");

        Optional<TicketOrder> order = isManager
                ? ticketOrderService.getTicketOrderForScreening(ticketOrderId, screeningId)
                : ticketOrderService.getTicketOrderForBuyerAndScreening(ticketOrderId, userId, screeningId);

        return order
                .map(ticketOrderMapper::toGetTicketOrderResponseDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(path = "/ticket-orders/{ticketOrderId}")
    public ResponseEntity<UpdateTicketOrderResponseDto> updateTicketOrder(
            @AuthenticationPrincipal Jwt jwt,
            @PathVariable UUID ticketOrderId,
            @Valid @RequestBody UpdateTicketOrderRequestDto updateTicketOrderRequestDto) {

        if (!JwtHelper.hasRole(jwt, "MANAGER")) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        UpdateTicketOrderRequest updateTicketOrderRequest = ticketOrderMapper.fromDto(updateTicketOrderRequestDto);
        TicketOrder updatedTicketOrder = ticketOrderService.updateTicketOrder(ticketOrderId, updateTicketOrderRequest);
        return ResponseEntity.ok(ticketOrderMapper.toUpdatedTicketOrderResponseDto(updatedTicketOrder));
    }

    @DeleteMapping(path = "/ticket-orders/{ticketOrderId}")
    public ResponseEntity<Void> deleteTicketOrder(
            @AuthenticationPrincipal Jwt jwt,
            @PathVariable UUID ticketOrderId) {

        if (!JwtHelper.hasRole(jwt, "MANAGER")) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        ticketOrderService.deleteTicketOrder(ticketOrderId);
        return ResponseEntity.noContent().build();
    }

}
