package com.bstirbat.redis.performance.example.samplecache.service;

public interface RedisCacheService {

    String retrieveValue(String key);

    void setValue(String key, String value, long duration);
}
