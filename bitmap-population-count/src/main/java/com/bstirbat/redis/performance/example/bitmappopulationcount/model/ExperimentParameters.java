package com.bstirbat.redis.performance.example.bitmappopulationcount.model;

public class ExperimentParameters {

    private String key;

    private long populationNumber;

    private int maxRandom;

    private int lessThan;

    public ExperimentParameters() {

    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public long getPopulationNumber() {
        return populationNumber;
    }

    public void setPopulationNumber(long populationNumber) {
        this.populationNumber = populationNumber;
    }

    public int getMaxRandom() {
        return maxRandom;
    }

    public void setMaxRandom(int maxRandom) {
        this.maxRandom = maxRandom;
    }

    public int getLessThan() {
        return lessThan;
    }

    public void setLessThan(int lessThan) {
        this.lessThan = lessThan;
    }

    @Override
    public String toString() {
        return "ExperimentParameters{" +
                "key='" + key + '\'' +
                ", populationNumber=" + populationNumber +
                ", maxRandom=" + maxRandom +
                ", lessThan=" + lessThan +
                '}';
    }
}
