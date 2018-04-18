package com.bstirbat.redis.performance.example.samplecache.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class LongRunningValueComputer implements ValueComputer {

    private static final Logger logger = LoggerFactory.getLogger(LongRunningValueComputer.class);

    @Override
    public String computeValue(String key) {

        try {
            Thread.sleep(5 * 1000);
        } catch (Exception e) {
            logger.error("An error occurred sleeping", e);
        }

        Random rand = new Random();

        return key + "-value-" + rand.nextInt(100);
    }
}
