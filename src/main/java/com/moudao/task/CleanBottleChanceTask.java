package com.moudao.task;

import com.moudao.mapper.ChanceMapper;
import com.moudao.pojo.Chance;
import com.moudao.service.ChanceService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 这个是用来进行每日清除今日之前的捞瓶子的机会的
 * author: MrWang
 * date: 2018/3/28 20:33
 */
public class CleanBottleChanceTask {
    private static final Log log = LogFactory.getLog(CleanBottleChanceTask.class);
    @Autowired
    private ChanceMapper chanceMapper;

    private static final int RETRY_NUM = 10;

    public void cleanBottle() {
        chanceMapper.clearAll();
    }
}
