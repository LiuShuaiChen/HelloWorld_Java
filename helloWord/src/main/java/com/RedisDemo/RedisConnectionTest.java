package com.RedisDemo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;

public class RedisConnectionTest {


    private RedisConnection redisConnection;

    @Before
    public void before() {

        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        //设置redis连接池最大连接数量
        jedisPoolConfig.setMaxTotal(50);
        //设置redis连接池最大空闲数量
        jedisPoolConfig.setMaxIdle(10);
        //设置redis连接最小空闲数量
        jedisPoolConfig.setMinIdle(1);

        RedisConnection redisConnection = new RedisConnection();
        redisConnection.setIp("188.131.161.54");
        redisConnection.setPort(6379);
//        redisConnection.setPwd("");
        redisConnection.setClientName(Thread.currentThread().getName());
        redisConnection.setTimeout(600);
        redisConnection.setJedisPoolConfig(jedisPoolConfig);

    }


    @Test
    public void testPutGet(){

        Jedis jedis = redisConnection.getJedis();

        try {
            jedis.select(1);
            jedis.set("name","grade");
            Assert.assertTrue("grade".equals("name"));
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (jedis != null) {
                jedis.close();
            }
        }


    }

}
