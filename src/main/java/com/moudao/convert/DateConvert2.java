package com.moudao.convert;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间字符串参数转换器
 * author: MrWang
 * date: 2018/3/29 16:19
 */
public class DateConvert2 implements Converter<String, Date> {
    private static final Log log  = LogFactory.getLog(DateConvert2.class);

    @Override
    public Date convert(String source) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return simpleDateFormat.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
            log.info("时间字符串参数转换失败", e);
        }
        return null;
    }
}
