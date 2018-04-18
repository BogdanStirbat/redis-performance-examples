package com.bstirbat.redis.performance.example.samplecache.controller;

import com.bstirbat.redis.performance.example.samplecache.service.RedisCacheService;
import com.bstirbat.redis.performance.example.samplecache.service.ValueComputer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValueController {

    private static final Logger logger = LoggerFactory.getLogger(ValueController.class);

    @Autowired
    private ValueComputer valueComputer;

    @Autowired
    private RedisCacheService redisCacheService;

    @GetMapping("/value/{key}")
    public String getValue(@PathVariable String key) {

        logger.info("Receive request, key=<{}>", key);

        String value = redisCacheService.retrieveValue(key);

        if (value == null) {
            logger.info("No value was found in cache for key=<{}>", key);
            value = valueComputer.computeValue(key);
            redisCacheService.setValue(key, value, 10 * 1000);
            logger.info("For key=<{}> cached value=<{}>", key, value);
        }

        return value;
    }
}
