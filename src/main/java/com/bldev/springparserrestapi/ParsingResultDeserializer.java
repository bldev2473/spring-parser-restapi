package com.bldev.springparserrestapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

public class ParsingResultDeserializer implements Deserializer {
    @Override
    public Object deserialize(String topic, byte[] data) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            ParsingResult parsingResult = null;
            try {
                parsingResult = mapper.readValue(data, ParsingResult.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return parsingResult;
        } catch (Exception e) {
            throw new SerializationException("SerializationException");
        }
    }
}
