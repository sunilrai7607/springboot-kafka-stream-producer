package com.sbr.rest.api.message.brokers.model.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Reservation {

    private String id;

    private String passengerName;

    private String reservationDate;

}
