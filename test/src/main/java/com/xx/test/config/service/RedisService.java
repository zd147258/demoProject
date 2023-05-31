package com.xx.test.config.service;

import redis.clients.jedis.Jedis;

public interface RedisService {
    public Jedis getResource();

    public void returnResource(Jedis jedis);

    public void set(String key, String value);

    public void setex(String key, int seconds, String value);

    public String get(String key);

    public void del(String key);
}
