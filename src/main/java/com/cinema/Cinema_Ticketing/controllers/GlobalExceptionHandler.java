package com.cinema.Cinema_Ticketing.controllers;

import com.cinema.Cinema_Ticketing.domain.dtos.ErrorDto;
import com.cinema.Cinema_Ticketing.exceptions.*;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDto> handleUserNotFoundException(UserNotFoundException ex) {
        log.error("Caught UserNotFoundException", ex);
        ErrorDto errorDto = new ErrorDto();
        errorDto.setError("User not found");
        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CinemaNotFoundException.class)
    public ResponseEntity<ErrorDto> handleCinemaNotFoundException(CinemaNotFoundException ex) {
        log.error("Caught CinemaNotFoundException", ex);
        ErrorDto errorDto = new ErrorDto();
        errorDto.setError("Cinema not found");
        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HallNotFoundException.class)
    public ResponseEntity<ErrorDto> handleHallNotFoundException(HallNotFoundException ex) {
        log.error("Caught HallNotFoundException", ex);
        ErrorDto errorDto = new ErrorDto();
        errorDto.setError("Hall not found");
        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SeatNotFoundException.class)
    public ResponseEntity<ErrorDto> handleSeatNotFoundException(SeatNotFoundException ex) {
        log.error("Caught SeatNotFoundException", ex);
        ErrorDto errorDto = new ErrorDto();
        errorDto.setError("Seat not found");
        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ScreeningNotFoundException.class)
    public ResponseEntity<ErrorDto> handleScreeningNotFoundException(ScreeningNotFoundException ex) {
        log.error("Caught ScreeningNotFoundException", ex);
        ErrorDto errorDto = new ErrorDto();
        errorDto.setError("Screening not found");
        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MovieNotFoundException.class)
    public ResponseEntity<ErrorDto> handleMovieNotFoundException(MovieNotFoundException ex) {
        log.error("Caught MovieNotFoundException", ex);
        ErrorDto errorDto = new ErrorDto();
        errorDto.setError("Movie not found");
        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TicketNotFoundException.class)
    public ResponseEntity<ErrorDto> handleTicketNotFoundException(TicketNotFoundException ex) {
        log.error("Caught TicketNotFoundException", ex);
        ErrorDto errorDto = new ErrorDto();
        errorDto.setError("Ticket not found");
        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TicketOrderNotFoundException.class)
    public ResponseEntity<ErrorDto> handleTicketOrderNotFoundException(TicketOrderNotFoundException ex) {
        log.error("Caught TicketOrderNotFoundException", ex);
        ErrorDto errorDto = new ErrorDto();
        errorDto.setError("Ticket order not found");
        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TicketOrderUpdateException.class)
    public ResponseEntity<ErrorDto> handleTicketOrderUpdateException(TicketOrderUpdateException ex) {
        log.error("Caught TicketOrderUpdateException", ex);
        ErrorDto errorDto = new ErrorDto();
        errorDto.setError("Unable to update ticket order");
        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CinemaTicketException.class)
    public ResponseEntity<ErrorDto> handleCinemaTicketException(CinemaTicketException ex) {
        log.error("Caught CinemaTicketException", ex);
        ErrorDto errorDto = new ErrorDto();
        errorDto.setError(ex.getMessage());
        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorDto> handleConstraintViolation(ConstraintViolationException ex) {
        log.error("Caught ConstraintViolationException", ex);
        ErrorDto errorDto = new ErrorDto();

        String errorMessage = ex.getConstraintViolations()
                .stream()
                .findFirst()
                        .map(violation -> violation.getPropertyPath() + ": " + violation.getMessage()
                        ).orElse("Constraint violation occurred");

        errorDto.setError(errorMessage);
        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDto> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        log.error("Caught MethodArgumentNotValidException", ex);
        ErrorDto errorDto = new ErrorDto();

        BindingResult bindingResult = ex.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        String errorMessage = fieldErrors.stream()
                        .findFirst()
                                .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
                                        .orElse("Validation error occurred");

        errorDto.setError(errorMessage);
        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDto> handleException(Exception ex) {
        log.error("Caught exception", ex);
        ErrorDto errorDto = new ErrorDto();
        errorDto.setError("An unknown error occurred");
        return new ResponseEntity<>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
