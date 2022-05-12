import models.DataSimulation;
import models.Platform;
import models.Sensor;
import strategy.samplingType.impl.BinarySamplingTypeStrategyImpl;
import strategy.samplingType.impl.RangeSamplingTypeStrategyImpl;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;

public class Application {

    public static void main(String[] args) {
        Sensor sensor1 = new Sensor(new BinarySamplingTypeStrategyImpl());
        Sensor sensor2 = new Sensor(new RangeSamplingTypeStrategyImpl(-40, 40));

//        ExecutorService executorService

//        for (int i = 0; i<10; i+=1) {
//            System.out.println("Sensor 1 " + sensor1.getSensorValue());
//            System.out.println("Sensor 2 " + sensor2.getSensorValue());
//        }

        DataSimulation dataSimulation = new DataSimulation(Arrays.asList(sensor1, sensor2), new Platform("www.abcd.com"), 100, 10);
        DataSimulation dataSimulation2 = new DataSimulation(Arrays.asList(sensor1), new Platform("www.abcd.com"), 100, 10);

        dataSimulation.startSimulation();
    }
}
