package com.bldev.springparserrestapi;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class HdfsSinkController {
    private final static String BOOTSTRAP_SERVERS = "my-kafka:9092";
    private final static String TOPIC_NAME = "spring-parser-restapi";
    private final static String GROUP_ID = "hdfs-save-consumer-group";
    private final static int CONSUMER_COUNT = 3;

    private final static List<ConsumerWorker> workers = new ArrayList<>();
    public void startConsumerWorker() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            log.info("Shutdown hook");
            workers.forEach(ConsumerWorker::stopAndWakeup);
        }));
    }
}
