package com.moudao.config;

import net.sf.ehcache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;

/**
 * 整合启用ehcache缓存
 * 之所以将下面的方法注释掉，是因为本工程使用了shiro，而shiro中是使用了ehcache缓存，在加载shiro的时候就会创建一个net.sf.ehcache.CacheManager
 * 的实例，而在ehcache2.5版本之后，net.sf.ehcache.CacheManager被设计为了单例类，因此回报无法创建这个实例，因此在这里采用net.sf.ehcache.CacheManager
 * 的静态方法net.sf.ehcache.CacheManager.create()方法来重用那个单例对象
 * author: MrWang
 * date: 2018/4/6 18:06
 */
@Configuration
@EnableCaching
public class EhCacheConfig {
    @Bean
    public EhCacheCacheManager cacheCacheManager(/*CacheManager cacheManager*/) {
        CacheManager cacheManager1 = CacheManager.create();
        return new EhCacheCacheManager(cacheManager1);
    }

    /**
     * 这个配置其实是为了向上面那个方法提供一个CacheManager，创建的EhCacheManagerFactoryBean其实是一个CacheManager的实例，可以进入
     * EhCacheManagerFactoryBean的构造方法就能发现这一点
     * @return
     */
    /*@Bean
    public EhCacheManagerFactoryBean ehCacheManagerFactoryBean() {
        EhCacheManagerFactoryBean ehCacheManagerFactoryBean = new EhCacheManagerFactoryBean();
        ehCacheManagerFactoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
        return ehCacheManagerFactoryBean;
    }*/
}
