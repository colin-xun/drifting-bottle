package com.moudao.cacheTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 这个类作为缓存的测试类
 * author: MrWang
 * date: 2018/4/6 22:00
 */
@Controller
@ResponseBody
public class CacheController {
    @Autowired
    private CacheService cacheService;

    @RequestMapping(value = "/cacheTest", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String cacheTest(){
        System.out.println("CacheController--》cacheTest被调用了！");
        return cacheService.cacheTest1();
    }

    @RequestMapping(value = "/person/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person savePerson(Person person){
        System.out.println(person);
        System.out.println("CacheController--》savePerson！");
        cacheService.savePerson(person);
        return person;
    }

    @RequestMapping(value = "/person/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person getPerson(@PathVariable("id") Integer id){
        System.out.println("CacheController--》getPerson(@PathVariable(\"id\") Integer id)！");
        return cacheService.getById(id);
    }
}
