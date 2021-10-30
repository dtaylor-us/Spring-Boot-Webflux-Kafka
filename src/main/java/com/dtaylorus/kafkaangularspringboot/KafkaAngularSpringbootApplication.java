package com.dtaylorus.kafkaangularspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class KafkaAngularSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaAngularSpringbootApplication.class, args);
    }

}
