package com.moudao.cacheTest;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

/**
 * cache测试：所有的注解既可以加在整个类上，表示对所有的方法生效，也可以单独加在方法上，表示只对这个方法生效
 * spel表达式：
 * #result：表示方法的返回值，这个不能加在Cacheable注解上
 * #root.args  表示传递给缓存方法的参数，形式为数组
 * #root.caches:该方法执行时所对应的缓存，形式为数组
 * #root.target:目标对象
 * #root.targetClass:目标对象的类，也可以写作#root.target.class
 * #root.method:缓存方法
 * #root.methodName:缓存方法的名称，也可以写作#root.method.name
 * #Argument:任意的方法参数名（如#argName)或参数索引（如#a0或#p0)
 * author: MrWang
 * date: 2018/4/6 22:09
 */
public interface CacheService {
    String cacheTest1();

    //加在这里表示为所有的实现类都加了这个缓存,#result.id表示使用返回值的id作为缓存的key，CachePut表示方法总会被调用，
    // 然后就会存入缓存，这个注解很适合用于添加操作
    @CachePut(value = "savePerson", key = "#result.id")
    Person savePerson(Person person);

    @Cacheable(value = "getperson", unless = "#result.name.contains('noCache')", condition = "#id <= 30")
    Person getById(Integer id);

    //beforeInvocation = false在方法调用之后移除缓存；allEntries = false表示只有对应的key会被移除，为true时getPerson下的所有的条目都会被移除
    @CacheEvict(value = "getPerson", allEntries = false, beforeInvocation = false)
    void removePerson(Integer id);
}
