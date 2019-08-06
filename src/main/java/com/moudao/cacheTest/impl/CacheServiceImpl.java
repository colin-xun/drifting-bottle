package com.moudao.cacheTest.impl;

import com.moudao.cacheTest.CacheService;
import com.moudao.cacheTest.Person;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;

/**
 * author: MrWang
 * date: 2018/4/6 22:09
 */
@Service
public class CacheServiceImpl implements CacheService {
    @Override
    @Cacheable(value = "cacheTest1")    //表明会先查找缓存，加在这里表示只对这个实现类的方法有效，key默认为这个方法的参数
    public String cacheTest1() {
        System.out.println("cacheTest调用了，没有调用缓存");
        return "cacheTest";
    }

    @Override
    public Person savePerson(Person person) {
        System.out.println("CacheServiceImpl---》public Person savePerson(Person person)被调用了 ");
        person.setId(new Random().nextInt(100));
        return person;
    }

    @Override
    public Person getById(Integer id) {
        System.out.println("CacheServiceImpl---》public Person getById(Integer id)被调用了");
        Person person = new Person();
        person.setId(id);
        person.setName("默认的名字");
        person.setCreateTime(new Date());
        return person;
    }

    @Override
    public void removePerson(Integer id) {

    }
}
