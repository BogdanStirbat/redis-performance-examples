package com.bstirbat.redis.performance.example.bitmappopulationcount.service;

import com.bstirbat.redis.performance.example.bitmappopulationcount.model.ExperimentParameters;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

import java.util.Random;

@Service
public class RedisServiceImpl implements RedisService {

    private Jedis jedis;

    public RedisServiceImpl() {
        jedis = new Jedis("localhost");
    }

    @Override
    public boolean keyExists(String key) {
        return jedis.get(key) != null;
    }

    @Override
    public void createExperiment(ExperimentParameters experimentParameters) {

        Random random = new Random();

        Pipeline pipeline = jedis.pipelined();

        for (long i = 0; i < experimentParameters.getPopulationNumber(); i++) {
            boolean value = random.nextInt(experimentParameters.getMaxRandom()) < experimentParameters.getLessThan();
            pipeline.setbit(experimentParameters.getKey(), i, value);
        }

        pipeline.sync();
    }

    @Override
    public long populationCount(String key) {

        if (!keyExists(key)) {
            throw new RuntimeException("Called population count for non-existing key: " + key);
        }

        return jedis.bitcount(key);
    }
}
