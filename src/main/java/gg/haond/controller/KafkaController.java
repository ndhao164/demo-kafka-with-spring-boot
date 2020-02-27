package gg.haond.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gg.haond.service.KafkaSender;

@RestController
public class KafkaController {
	@Autowired
	private KafkaSender kafkaSender;

	@GetMapping(value = "/send-message")
	public String producer(@RequestParam("message") String message) {
		kafkaSender.send(message);
		return "Message sent to the Kafka Topic demokafka Successfully";
	}
}
