package com.sbr.rest.api.message.brokers.controllers;

import com.sbr.rest.api.message.brokers.model.response.BookingStatus;
import com.sbr.rest.api.message.brokers.model.request.BookingRequest;
import com.sbr.rest.api.message.brokers.services.BookingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/bookings", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping(value = "/taxi", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookingStatus> createBooking(@RequestBody BookingRequest bookingRequest){
        return ResponseEntity.ok(bookingService.booking(bookingRequest));
    }
}
