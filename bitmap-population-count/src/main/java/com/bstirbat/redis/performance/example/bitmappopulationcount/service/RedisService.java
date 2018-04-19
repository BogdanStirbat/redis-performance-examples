package com.bstirbat.redis.performance.example.bitmappopulationcount.service;

import com.bstirbat.redis.performance.example.bitmappopulationcount.model.ExperimentParameters;

public interface RedisService {

    boolean keyExists(String key);

    void createExperiment(ExperimentParameters experimentParameters);

    long populationCount(String key);
}
