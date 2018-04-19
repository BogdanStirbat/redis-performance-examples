package com.bstirbat.redis.performance.example.bitmappopulationcount.controller;

import com.bstirbat.redis.performance.example.bitmappopulationcount.model.ExperimentParameters;
import com.bstirbat.redis.performance.example.bitmappopulationcount.service.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExperimentsController {

    private static final Logger logger = LoggerFactory.getLogger(ExperimentsController.class);

    @Autowired
    private RedisService redisService;

    @PostMapping("/experiments/create")
    public String generateExperiment(@RequestBody ExperimentParameters experimentParameters) {

        logger.info("Received create new experiment request, parameters=<{}>", experimentParameters);
        redisService.createExperiment(experimentParameters);
        logger.info("Finished populating experiment, <{}>", experimentParameters);

        return experimentParameters.getKey();
    }

    @GetMapping("/experiments/{key}")
    public long computePopulationCount(@PathVariable String key) {

        logger.info("Received computePopulationCount request, key=<{}>", key);
        long populationCount = redisService.populationCount(key);
        logger.info("Finished computing populationCount, key=<{}>", key);

        return populationCount;
    }
}
