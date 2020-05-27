package gg.haond.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import gg.haond.model.ContentFile;

@Service
public class KafkaReceive {
    
    @Autowired
    FileService fileService;
	
	@KafkaListener(topics = "demokafka")
	public void consume(ContentFile message) throws IOException{
	    fileService.saveFileReceive(message.getFile());
	}
}
