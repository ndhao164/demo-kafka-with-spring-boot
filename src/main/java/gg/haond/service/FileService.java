package gg.haond.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import gg.haond.model.ContentFile;

@Service
@Transactional
public class FileService {
    @Autowired
    KafkaSender kafkaSender;
    
    
    private String dir2 = "/home/haond/Desktop/kafka/file/";
    private String dirSender = "/home/haond/Desktop/kafka/kafka-sender/";

    public void uploadFile(MultipartFile file) throws IllegalStateException, IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String fileNameSaved = String.valueOf(new Random().nextInt()).concat("-").concat(fileName);
        File fileSender = new File(dirSender.concat(fileNameSaved));
        file.transferTo(fileSender);
        sendTopic(fileSender, fileNameSaved);
    }
    
    public void sendTopic(File file, String fileName) throws IOException {
        ContentFile cf = new ContentFile(file);
        kafkaSender.send(cf);
    }
    public void saveFileReceive(File file) throws IOException {
        File fileSouce = new File(dir2.concat(file.getName()));
        Files.copy(file.toPath(), fileSouce.toPath(), StandardCopyOption.REPLACE_EXISTING);
        file.delete();
    }
}
