package com.moudao.controller;

import com.moudao.service.PraiseService;
import com.moudao.util.Result;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * author: MrWang
 * date: 2018/3/29 14:31
 */
@Controller
@RequestMapping("/praise")
public class PraiseController {
    private static final Log log = LogFactory.getLog(PraiseController.class);

    @Autowired
    private PraiseService praiseService;

    /**
     * 对瓶子或者用户的评论进行点赞
     * @param targetId
     * @param userId
     * @param catetory 表示这个赞的类型是瓶子（0）/评论（1）
     * @return
     */
    @RequestMapping(value = "/create/{targetId}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Result praiseBottle(@PathVariable("targetId") Integer targetId,
                               @RequestParam(value = "userId", required = true) Integer userId,
                               @RequestParam(value = "catetory", required = true) Byte catetory) {
        if(catetory != 0 && catetory != 1){
            return Result.fail("参数类型错误");
        }
        try{
            return praiseService.create(targetId, userId, catetory);
        } catch (Exception e) {
            log.info("点赞失败", e);
            return Result.fail("点赞失败");
        }
    }

}
