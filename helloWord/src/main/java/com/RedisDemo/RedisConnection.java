package com.RedisDemo;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisConnection {

    //redis连接池配置信息
    private JedisPoolConfig jedisPoolConfig;

    //redis连接地址
    private String ip;

    //redis 服务器连接端口
    private Integer port;

    //redis服务器连接密码
    private String pwd;

    //redis服务器连接超时时间
    private Integer timeout;

    // 连接客户端名称
    private String clientName = null;

    private JedisPool jedisPool;

    public JedisPoolConfig getJedisPoolConfig() {
        return jedisPoolConfig;
    }

    public void setJedisPoolConfig(JedisPoolConfig jedisPoolConfig) {
        this.jedisPoolConfig = jedisPoolConfig;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    private void buildConnection() {
        if (jedisPool == null) {
            if (jedisPoolConfig == null) {
                jedisPool = new JedisPool(new JedisPoolConfig(), ip, port, timeout, pwd, 0, clientName);
            } else {
                jedisPool = new JedisPool(jedisPoolConfig, ip, port, timeout, pwd, 0, clientName);
            }
        }
    }

//    private void buildConnection() {
//        if (jedisPool == null) {
//            if (jedisPoolConfig == null) {
//                jedisPool = new JedisPool(new JedisPoolConfig(), ip, port, timeout, pwd, 0, clientName);
//            } else {
//                jedisPool = new JedisPool(jedisPoolConfig, ip, port, timeout, pwd, 0, clientName);
//            }
//        }
//    }

    public Jedis getJedis() {
        buildConnection();
        if (jedisPool != null) {
            return jedisPool.getResource();
        }
        return null;
    }

}
