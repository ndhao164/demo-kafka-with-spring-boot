package gg.haond.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import gg.haond.service.FileService;
import gg.haond.service.KafkaSender;

@RestController
public class KafkaController {
	@Autowired
	KafkaSender kafkaSender;
	
	@Autowired
	FileService fileService;

	@GetMapping(value = "/send-message")
	public String producer(@RequestParam("message") String message) {
//		kafkaSender.send(message);
		return "Message sent to the Kafka Topic demokafka Successfully";
	}
	
	@PostMapping("/file")
    public @ResponseBody HttpStatus uploadFile(@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException{
	    fileService.uploadFile(file);
        return HttpStatus.OK;
    }
}
