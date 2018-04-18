package com.bstirbat.redis.performance.example.samplecache.service;

import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

@Service
public class RedisCacheServiceImpl implements RedisCacheService {

    private Jedis jedis;

    public RedisCacheServiceImpl() {
        jedis = new Jedis("localhost");
    }

    @Override
    public String retrieveValue(String key) {
        return jedis.get(key);
    }

    @Override
    public void setValue(String key, String value, long duration) {
        jedis.set(key, value);
        jedis.pexpire(key, duration);
    }
}
