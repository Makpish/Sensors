package strategy.samplingType.impl;

import strategy.samplingType.SamplingTypeStrategy;

public class BinarySamplingTypeStrategyImpl implements SamplingTypeStrategy {
    @Override
    public Object getSensorValue() {
        if (Math.random() > 0.5)
            return 0;
        return 1;
    }
}
