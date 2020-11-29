package com.sbr.rest.api.message.brokers.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
@Data
@EnableBinding(Source.class)
public class Producer {

    private Source messageSource;

    public Producer(Source messageSource) {
        super();
        this.messageSource = messageSource;
    }
}
