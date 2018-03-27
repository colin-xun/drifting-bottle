package com.moudao.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理
 * author: MrWang
 * date: 2018/3/27 17:11
 */
public class GlobalExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        //      解析出异常类型
//      如果该 异常类型是系统 自定义的异常，直接取出异常信息，在错误页面展示
//      如果该 异常类型不是系统 自定义的异常，构造一个自定义的异常类型（信息为“未知错误”）
        CustomerException customerException=null;
        if(ex instanceof CustomerException){
            customerException = (CustomerException)ex;
        }else{
            customerException = new CustomerException("未知错误！");
        }
        String message = ex.getMessage();
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("message", message);
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
