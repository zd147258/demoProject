package com.xx.test.config;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Slf4j
@Component
@PropertySource("classpath:application.properties")
@ConfigurationProperties(prefix = "spring.redis")
public class RedisConfig {

    private String hostName;

    private int port;

    //private String password;

    private int timeout;


    //@Bean    //此处注入JedisPoolConfig对象没有意义，不需要
    public JedisPoolConfig getRedisConfig(){
        JedisPoolConfig config = new JedisPoolConfig();
        return config;
    }

    @Bean//@Bean注解将一个配置类的方法的返回值定义为一个bean，注册到spring里面
    public JedisPool getJedisPool(){
        JedisPoolConfig config = getRedisConfig();
        JedisPool pool = new JedisPool(config,hostName,port);
        log.info("init JredisPool ...");
        return pool;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }
}
