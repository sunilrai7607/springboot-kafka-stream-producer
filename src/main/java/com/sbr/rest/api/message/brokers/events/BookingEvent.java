package com.sbr.rest.api.message.brokers.events;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sbr.rest.api.message.brokers.config.Producer;
import com.sbr.rest.api.message.brokers.model.domain.Reservation;
import com.sbr.rest.api.message.brokers.model.request.BookingRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.UUID;

@Component
@Slf4j
public class BookingEvent {

    private final Producer producer;
    private final static String MESSAGE_KEY = "x-taxi-message";

    @Autowired
    public BookingEvent(Producer producer) {
        this.producer = producer;
    }

    /**
     * Method to produce a booking message
     * @param bookingRequest
     * @return
     */
    public String publishBookingEvent(BookingRequest bookingRequest) {
        log.info("Reservation Request : {} ",bookingRequest);
        boolean sendStatus = producer.getMessageSource()
                .output()
                .send(createMessage(bookingRequest));
        log.info("Produce Message Status : {} ", sendStatus);

        return sendStatus ? "Reservation Request Id : "+bookingRequest.getRequestId() : "Reservation request failed";
    }

    private Message<?> createMessage(BookingRequest bookingRequest) {
        return MessageBuilder
                .withPayload(buildPayLoad(bookingRequest))
                .setHeader(KafkaHeaders.MESSAGE_KEY,MESSAGE_KEY)
                .setHeader("partitionKey","1")
                .setHeader("type","booking")
                .build();
    }


    private String buildPayLoad(BookingRequest bookingRequest) {
        try {
            bookingRequest.setRequestId(UUID.randomUUID().toString());
            Reservation reservation = new Reservation();
            reservation.setId(bookingRequest.getRequestId());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE dd-MMM-yy HH:mm:ssZ");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("America/New_York"));
            reservation.setReservationDate(simpleDateFormat.format(new Date()));
            reservation.setPassengerName(bookingRequest.getPassengerName());
            return new ObjectMapper().writeValueAsString(reservation);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }


}
