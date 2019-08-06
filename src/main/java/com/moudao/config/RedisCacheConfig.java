package com.moudao.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 配置使用全局的redis缓存
 * 三部曲：
 * 1：配置一个redisConnectionFactory
 * 2：配置一个redisTemplate
 * 3：配置一个org.springframework.cache.CacheManager(org.springframework.data.redis.cache.RedisCacheManager)
 * author: MrWang
 * date: 2018/4/6 19:16
 */
@Configuration
@EnableCaching
public class RedisCacheConfig {

    @Bean
    public RedisCacheManager redisCacheManager(RedisTemplate redisTemplate){
        return new RedisCacheManager(redisTemplate);
    }

    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

    @Bean
    public RedisConnectionFactory redisConnectionFactory(){
//        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration("192.168.1.128",6379);
//        redisStandaloneConfiguration.setPassword("xxxxxx");   //如果设置了密码，这里进行配置
//        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(redisStandaloneConfiguration);
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.setHostName("192.168.1.128");
        jedisConnectionFactory.setPort(6379);
        jedisConnectionFactory.setPoolConfig(jedisPoolConfig());   //回头在研究使用这个新的配置而不使用过时的配置
        jedisConnectionFactory.afterPropertiesSet();
        return jedisConnectionFactory;
    }

    /* <bean id="jedisPoolConfig" class="redis.clients.jedis.JedisPoolConfig">
        <property name="maxIdle" value="1" />
        <property name="maxTotal" value="5" />
        <property name="blockWhenExhausted" value="true" />
        <property name="maxWaitMillis" value="30000" />
        <property name="testOnBorrow" value="true" />
    </bean>*/
    @Bean
    public JedisPoolConfig jedisPoolConfig(){
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(20);
        config.setMaxTotal(50);
        config.setMaxWaitMillis(60000);
        return config;
    }


}
