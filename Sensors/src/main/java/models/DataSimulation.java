package models;

import java.util.List;

public class DataSimulation {

    private final List<Sensor> sensorList;
    private final Platform platform;
    private final long timeInSeconds;
    private final long waitTimeInSeconds;

    public DataSimulation(List<Sensor> sensorList, Platform platform, long timeInSeconds, long waitTimeInSeconds) {
        this.sensorList = sensorList;
        this.platform = platform;
        this.timeInSeconds = timeInSeconds;
        this.waitTimeInSeconds = waitTimeInSeconds;
    }

    public void startSimulation() {
        long startTime = 0;
        while (startTime < timeInSeconds) {
            for (Sensor sensor : sensorList) {
                System.out.println("Sensor sending data = " + sensor.getSensorValue() +  " to platform " + platform.getUrl());
            }
//            time.sleep(waitTimeInSeconds);
            startTime+=waitTimeInSeconds;
        }
    }
}
