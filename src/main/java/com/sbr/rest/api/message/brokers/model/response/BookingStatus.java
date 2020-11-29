package com.sbr.rest.api.message.brokers.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class BookingStatus {

    String reservationId;

    String status;

    Date creationDate;

    public BookingStatus(String reservationId, String status) {
        this.reservationId = reservationId;
        this.status = status;
    }
}
