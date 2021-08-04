package com.bldev.springparserrestapi;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

public class Listener {
    private static final Logger log = LoggerFactory.getLogger(RestParserConfiguration.class);

    @KafkaListener(
            topics = "parsing-result",
            groupId = "parsing-result-group-00"
    )
    public void recordListener(ConsumerRecord<String, String> record) {
        log.info(record.toString());
    }
}
