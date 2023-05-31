package com.xx.test.config.service.impl;

import com.xx.test.config.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Slf4j
@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private JedisPool jedisPool;

    @Override
    public Jedis getResource() {
        return jedisPool.getResource();
    }

    @SuppressWarnings("deprecation")
    @Override
    public void returnResource(Jedis jedis) {
        if (jedis != null){
            jedisPool.returnResourceObject(jedis);
        }
    }

    @Override
    public void set(String key, String value) {
        Jedis jedis=null;
        try{
            jedis = getResource();
            jedis.set(key, value);
            log.info("Redis set success - " + key + ", value:" + value);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Redis set error: "+ e.getMessage() +" - " + key + ", value:" + value);
        }finally{
            returnResource(jedis);
        }
    }

    @Override
    public void setex(String key, int seconds, String value) {
        Jedis jedis = null;
        try {
            jedis = getResource();
            jedis.setex(key, seconds, value);
            log.info("Redis setex success - " + key + ", value:" + value + ", expTime:" + seconds);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("Redis setex error: " + key + ", value:" + value + ", expTime:" + seconds);
        } finally {
            returnResource(jedis);
        }
    }

    @Override
    public String get(String key) {
        String result = null;
        Jedis jedis=null;
        try{
            jedis = getResource();
            result = jedis.get(key);
            log.info("Redis get success - " + key + ", value:" + result);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Redis set error: "+ e.getMessage() +" - " + key + ", value:" + result);
        }finally{
            returnResource(jedis);
        }
        return result;
    }

    @Override
    public void del(String key) {
        Jedis jedis = null;
        try {
            jedis = getResource();
            jedis.del(key);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }
}
