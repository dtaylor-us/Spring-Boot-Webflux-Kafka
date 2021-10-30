package com.dtaylorus.kafkaangularspringboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WeatherInfoEventProcessor {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private WeatherInfoEventListener listener;

    public void register(WeatherInfoEventListener listener) {
        this.listener = listener;
    }

    public void onEvent(WeatherInfoEvent event) {
        if (listener != null) {
            listener.onData(event);
        }
    }

    public void onComplete() {
        if (listener != null) {
            listener.processComplete();
        }
    }

    @KafkaListener(topics = "weather", groupId = "group_id")
    public void consume(WeatherInfoEvent message) throws IOException {
        logger.info(String.format("#### -> Consumed message -> %s", message));
        onEvent(message);
    }
}
