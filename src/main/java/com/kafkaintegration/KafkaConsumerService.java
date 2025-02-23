package com.kafkaintegration;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

	@KafkaListener(topics = "myTopic", groupId = "myGroup")
	public void listen(String message) {
		var logger = org.slf4j.LoggerFactory.getLogger(KafkaConsumerService.class);
		logger.info("Received message: {}", message);
	}
}