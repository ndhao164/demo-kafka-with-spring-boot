package gg.haond;

import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.databind.ObjectMapper;

import gg.haond.model.ContentFile;

public class KafkaSenderSerializer implements Serializer<ContentFile> {

    @Override
    public byte[] serialize(String topic, ContentFile data) {
        byte[] serializedBytes = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            serializedBytes = objectMapper.writeValueAsString(data).getBytes();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return serializedBytes;
    }
}
