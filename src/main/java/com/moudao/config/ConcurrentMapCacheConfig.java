package com.moudao.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置spring默认的缓存管理器
 * author: MrWang
 * date: 2018/4/6 19:19
 */
@Configuration
@EnableCaching
public class ConcurrentMapCacheConfig {
    @Bean
    public ConcurrentMapCacheManager concurrentMapCache(){
        return new ConcurrentMapCacheManager();
    }
}
