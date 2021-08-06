package com.bldev.springparserrestapi;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

public class Listener {
    private static final Logger log = LoggerFactory.getLogger(RestParserConfiguration.class);

    @Autowired
    ParsingResultRepository repository;

//    @KafkaListener(
//            topics = "parsing-result",
//            groupId = "parsing-result-group-00"
//    )
//    public void recordListener1(ConsumerRecord<String, String> record) {
//        log.info(record.toString());
////        repository.save(new ParsingResult(record.value())
//    }

    @KafkaListener(
            topics = "parsing-result1",
            groupId = "parsing-result1-group-00"
    )
    public void recordListener2(ConsumerRecord<String, ParsingResult> record) {
        log.info(record.toString());
//        repository.save(new ParsingResult(record.value().getFileName(), record.value().getLineNumber(), record.value().getTableName()));
        repository.save(record.value());
    }
}
