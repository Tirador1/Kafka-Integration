package com.kafkaintegration;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

	private final KafkaProducerService producerService;

	@Autowired
	public MessageController(KafkaProducerService producerService) {
		this.producerService = producerService;
	}

	@PostMapping("/send")
	public String sendMessage(@RequestParam String message) {
		producerService.sendMessage("myTopic", message);
		return "Message sent to Kafka topic";
	}
}