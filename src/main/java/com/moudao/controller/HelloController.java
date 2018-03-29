package com.moudao.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 测试controller了了了
 * author: MrWang
 * date: 2018/3/26 23:56
 */
@Controller
public class HelloController {
    private static final Log log = LogFactory.getLog(HelloController.class);

    @RequestMapping(value = "/index", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public String hello() {
        return "index";
    }
}
