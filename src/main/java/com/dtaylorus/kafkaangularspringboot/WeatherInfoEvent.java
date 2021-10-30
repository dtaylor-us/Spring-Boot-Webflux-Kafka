package com.dtaylorus.kafkaangularspringboot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherInfoEvent {
    private long stationId;
    private int temperature;
}
