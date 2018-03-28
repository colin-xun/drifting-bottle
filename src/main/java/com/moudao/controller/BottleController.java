package com.moudao.controller;

import com.moudao.pojo.BComment;
import com.moudao.pojo.Bottle;
import com.moudao.service.BottleService;
import com.moudao.service.ChanceService;
import com.moudao.service.CommentService;
import com.moudao.util.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * 这个是漂流瓶的模块
 * author: MrWang
 * date: 2018/3/28 10:52
 */
@Controller
@RequestMapping("/bottle")
public class BottleController {
    private static final Log log = LogFactory.getLog(BottleController.class);

    @Autowired
    private BottleService bottleService;

    @Autowired
    private CommentService commentService;

    /**
     * 扔瓶子，为了防止过凌晨之后，页面没有刷新的时候还显示可以扔瓶子，这里不把捞瓶子的机会用参数传过来，而是在数据库进行查找
     *
     * @param bottle
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Result insert(@Validated({InsertValid.class}) Bottle bottle, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            for (ObjectError objectError : bindingResult.getAllErrors()) {
                sb.append(objectError.getDefaultMessage()).append(";    ");
            }
            return Result.fail(sb.toString());
        }
        Integer bottleId = null;
        try {
            bottle.setCreatedTime(new Date());
            bottle.setUpdatedTime(new Date());
            return bottleService.insert(bottle);
        } catch (Exception e) {
            log.info("插入数据库失败", e);
            return Result.fail("扔漂流瓶失败");
        }
    }

    /**
     * 捞瓶子，实际上就是获取一个已经存在的瓶子
     * @param userId
     * @return
     */
    @RequestMapping(value = "/refloat/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Result refloat(@PathVariable(value = "userId", required = true) Integer userId) {
        int userId2 = userId.intValue();
        if (userId2 <= 0 || userId2 > Integer.MAX_VALUE) {
            return Result.fail("用户id有误，请重新输入");
        }
        Random r = new Random();
        int chargeFlag = r.nextInt(10);
        if (chargeFlag > 8) {
            return Result.fail("捞到一个海星");
        }
        try {
            return bottleService.selectByRandom(userId);
        } catch (Exception e) {
            log.info("获取漂流瓶失败", e);
            return Result.fail("获取漂流瓶失败");
        }
    }

    /**
     * 根据瓶子的id获取瓶子的详情，包括瓶子的赞数，瓶子的优质评论、一般评论，评论的赞数等
     * @param bottleId
     * @return
     */
    @RequestMapping(value = "/get/{bottleId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Result get(@PathVariable(value = "bottleId", required = true) Integer bottleId){
        try{
            Bottle bottle = bottleService.getByBottleId(bottleId);
            List<BComment> goodComments = commentService.selectComment(bottleId, Constant.COMMENT_GOOD);
            List<BComment> commonComments = commentService.selectComment(bottleId, Constant.COMMENT_COMMON);
            return Result.success(new BottleResultBean(bottle != null? bottle : "",goodComments,commonComments), "查询成功");
        } catch (Exception e) {
            log.info("查询瓶子失败", e);
            return Result.fail("查询瓶子失败");
        }
    }

    /**
     * 用户删除瓶子，实际为解除和瓶子的关系
     * @param bottleId
     * @param userId
     * @return
     */
    @RequestMapping(value = "/delete/{bottleId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Result deleteBottleByUser(@PathVariable(value = "bottleId", required = true) Integer bottleId, @RequestParam(value = "userId", required = true) Integer userId) {
        try {
            bottleService.deleteBottleByUser(bottleId, userId);
            return Result.success("删除瓶子成功");
        } catch (Exception e) {
            log.info("删除瓶子失败", e);
            return Result.fail("删除瓶子失败");
        }
    }

}
