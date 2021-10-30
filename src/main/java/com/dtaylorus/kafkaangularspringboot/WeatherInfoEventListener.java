package com.dtaylorus.kafkaangularspringboot;

public interface WeatherInfoEventListener {
    void onData(WeatherInfoEvent event);
    void processComplete();
}
