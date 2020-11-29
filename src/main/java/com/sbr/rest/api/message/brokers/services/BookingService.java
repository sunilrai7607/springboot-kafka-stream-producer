package com.sbr.rest.api.message.brokers.services;

import com.sbr.rest.api.message.brokers.events.BookingEvent;
import com.sbr.rest.api.message.brokers.model.request.BookingRequest;
import com.sbr.rest.api.message.brokers.model.response.BookingStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {


    private final BookingEvent bookingEvent;

    @Autowired
    public BookingService(BookingEvent bookingEvent) {
        this.bookingEvent = bookingEvent;
    }

    public BookingStatus booking(final BookingRequest bookingRequest) {
        String bookingNumber = bookingEvent.publishBookingEvent(bookingRequest);
        BookingStatus bookingStatus = new BookingStatus(bookingNumber, "Conformed");
        return null;
    }
}
