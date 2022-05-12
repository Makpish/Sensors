package strategy.samplingType.impl;

import strategy.samplingType.SamplingTypeStrategy;

public class RangeSamplingTypeStrategyImpl implements SamplingTypeStrategy {

    private final int start;
    private final int end;

    public RangeSamplingTypeStrategyImpl(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public Object getSensorValue() {
        return (int) ((Math.random() * (end - start)) + start);
    }
}
