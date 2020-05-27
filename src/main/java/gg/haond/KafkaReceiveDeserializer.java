package gg.haond;

import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;

import gg.haond.model.ContentFile;

public class KafkaReceiveDeserializer implements Deserializer<ContentFile>{

    @Override
    public ContentFile deserialize(String topic, byte[] data) {
        ObjectMapper mapper = new ObjectMapper();
        ContentFile cf = null;
        try {
            cf = mapper.readValue(data, ContentFile.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cf;
    }

}
