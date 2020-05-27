package gg.haond.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import gg.haond.model.ContentFile;

@Service
public class KafkaSender {
	@Autowired
	KafkaTemplate<String, ContentFile> kafkaTemplate;
	
	@Autowired
	FileService fileService;
	
	String kafkaTopic = "demokafka";
	
	public void send(ContentFile message) {
	    kafkaTemplate.send(kafkaTopic, message);
	    System.out.println("-------------- SEND DONE");
	}
}
