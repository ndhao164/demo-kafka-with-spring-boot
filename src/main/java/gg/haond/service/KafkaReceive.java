package gg.haond.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaReceive {
	
	@KafkaListener(topics = "demokafka")
	public void consume(String message) {
		System.out.println("kafke receive message: " + message);
	}
}
