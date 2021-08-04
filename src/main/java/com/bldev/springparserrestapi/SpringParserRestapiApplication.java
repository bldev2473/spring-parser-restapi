package com.bldev.springparserrestapi;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class SpringParserRestapiApplication {
	private static final Logger log = LoggerFactory.getLogger(RestParserConfiguration.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringParserRestapiApplication.class, args);
	}
}
