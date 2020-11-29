package com.sbr.rest.api.message.brokers.model.request;

import com.sbr.rest.api.message.brokers.model.enums.TaxiTypes;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class BookingRequest {

    @Builder.Default
    private String requestId = UUID.randomUUID().toString();

    private TaxiTypes taxiTypes;

    private String passengerName;
}
