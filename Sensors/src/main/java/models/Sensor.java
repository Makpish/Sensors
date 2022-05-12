package models;

import strategy.samplingType.SamplingTypeStrategy;

public class Sensor {
    private final SamplingTypeStrategy strategy;


    public Sensor(SamplingTypeStrategy strategy) {
        this.strategy = strategy;
    }

    public Object getSensorValue() {
        return strategy.getSensorValue();
    }
}
