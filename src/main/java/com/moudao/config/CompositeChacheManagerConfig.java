package com.moudao.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.support.CompositeCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheManager;

import java.util.ArrayList;
import java.util.List;

/**
 * 管理多个缓存管理器
 * author: MrWang
 * date: 2018/4/6 19:55
 */
@EnableCaching   //在这里应该不需要使用这个？？？
@Configuration
public class CompositeChacheManagerConfig {
    @Bean
    @Primary    //默认使用这个作为cacheManager，来统一管理cacheManager，就会按照添加的顺序进行迭代查找缓存，直到找到为止
    public CompositeCacheManager compositeCacheManager(EhCacheCacheManager ehCacheCacheManager, RedisCacheManager redisCacheManager, ConcurrentMapCacheManager concurrentMapCacheManager){
        CompositeCacheManager compositeCacheManager = new CompositeCacheManager();
        List<CacheManager> cacheManagers = new ArrayList<>();
        cacheManagers.add(ehCacheCacheManager);
        cacheManagers.add(redisCacheManager);
        cacheManagers.add(concurrentMapCacheManager);
        compositeCacheManager.setCacheManagers(cacheManagers);
        return compositeCacheManager;
    }
}
