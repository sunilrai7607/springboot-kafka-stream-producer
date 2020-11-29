package com.sbr.rest.api.message.brokers;

import com.sbr.rest.api.message.brokers.services.BookingService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = BookingService.class)
@ActiveProfiles("test")
class KafkaApplicationTests {

	@Test
	void contextLoads() {
	}

}
