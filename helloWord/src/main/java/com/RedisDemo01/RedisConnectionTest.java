package com.RedisDemo01;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.ScanResult;

import java.util.Set;
import java.util.UUID;

public class RedisConnectionTest {


    private RedisConnection redisConnection;

    @Before
    public void before() {

        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        //设置 redis 连接池最大连接数量
        jedisPoolConfig.setMaxTotal(50);
        //设置 redis 连接池最大空闲连接数量
        jedisPoolConfig.setMaxIdle(10);
        //设置 redis 连接池最小空闲连接数量
        jedisPoolConfig.setMinIdle(1);
        redisConnection = new RedisConnection();
        redisConnection.setIp("192.168.136.200");
        redisConnection.setPort(6379);
//        redisConnection.setPwd("test123");
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

            for (int i = 0; i < 50; i++) {
                jedis.set(i+"hello",i+"word.." + Math.random());
            }

            jedis.set("fallback","helloworld");

            //断言语句
            Assert.assertTrue("grade".equals(jedis.get("name")));

            //获取所有的keys
            Set<String> keys = jedis.keys("*");
            System.out.println(keys.size());

            //再根据这些key获取所有的value
//            for (String key : keys) {
//                System.out.println(jedis.get(key));
//            }

            //删除库里的所有数据
//            String s = jedis.flushDB();
//            System.out.println(s);

            ScanResult<String> scan = jedis.scan("0");
            System.err.println(scan.getResult());

            // 一个list集合
//            for (int i = 0; i < 10; i++) {
//                jedis.lpush("list_alice","" + UUID.randomUUID());
//            }

            System.out.println(jedis.lpop("list_alice").length());

            System.out.println(jedis.get("fallback"));
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (jedis != null) {
                jedis.close();
            }
        }


    }

}
