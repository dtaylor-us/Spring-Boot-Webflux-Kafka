package com.dtaylorus.kafkaangularspringboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

// TODO: MOVE MOCK CALL TO AN EXTERNAL SERVICE
@Service
public class WeatherInfoService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private KafkaTemplate<String, WeatherInfoEvent> kafkaTemplate;

    public ListenableFuture<SendResult<String, WeatherInfoEvent>> sendMessage(String topic, WeatherInfoEvent message) {
        logger.info(String.format("#### -> Producing message -> %s", message));
        return this.kafkaTemplate.send(topic, message);
    }

    @Scheduled(fixedDelay = 5000)
    public void getWeatherInfoJob() throws IOException {
        logger.info("generate fake weather event");
        // fake event
        long stationId = ThreadLocalRandom.current().nextLong(100);
        int temperature = ThreadLocalRandom.current().nextInt(16, 30);
        WeatherInfoEvent event = new WeatherInfoEvent(stationId, temperature);
        sendMessage("weather", event);
    }
}
