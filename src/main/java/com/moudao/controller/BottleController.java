package com.moudao.controller;

import com.moudao.pojo.BComment;
import com.moudao.pojo.Bottle;
import com.moudao.service.BottleService;
import com.moudao.service.CommentService;
import com.moudao.util.BottleResultBean;
import com.moudao.util.Constant;
import com.moudao.util.InsertValid;
import com.moudao.util.Result;
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
     *
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
     *
     * @param bottleId
     * @return
     */
    @RequestMapping(value = "/get/{bottleId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Result get(@PathVariable(value = "bottleId", required = true) Integer bottleId) {
        try {
            Bottle bottle = bottleService.getByBottleId(bottleId);
            List<BComment> goodComments = commentService.selectComment(bottleId, Constant.COMMENT_GOOD);
            List<BComment> commonComments = commentService.selectComment(bottleId, Constant.COMMENT_COMMON);
            return Result.success(new BottleResultBean(bottle != null ? bottle : "", goodComments, commonComments), "查询成功");
        } catch (Exception e) {
            log.info("查询瓶子失败", e);
            return Result.fail("查询瓶子失败");
        }
    }

    /**
     * 用户删除瓶子，实际为解除和瓶子的关系
     *
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

    /**
     * 根据用户的id和用户扔出的瓶子/用户捞的瓶子类型进行分页查询
     * @param userId
     * @param bottleCategory 代表是用户扔出的瓶子（1）还是了捞到的瓶子（0）
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/list/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Result getListByUserId(@PathVariable(value = "userId", required = true) Integer userId,
                                  @RequestParam(value = "bottleCategory", required = true) Byte bottleCategory,
                                  @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                  @RequestParam(value = "pageSize", required = false, defaultValue = "15") Integer pageSize) {
        try {
            return bottleService.getListByUserId(userId, bottleCategory, page, pageSize);
        } catch (Exception e) {
            log.info("查询失败", e);
            return Result.fail("查询失败");
        }
    }

    /**
     * 按时间间隔统计用户扔出的瓶子和捞的瓶子的数量
     * @param userId
     * @param startTime
     * @param endTime
     * @return
     */
    @RequestMapping(value = "/listCountByTime/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Result getUserListCountByTime(@PathVariable(value = "userId", required = true) Integer userId,
                                         @RequestParam(value = "startTime", required = true) Date startTime,
                                         @RequestParam(value = "endTime", required = true) Date endTime) {
        if (startTime.compareTo(endTime) > 0) {
            return Result.fail("开始不能大于结束时间");
        }
        if (startTime.compareTo(new Date()) > 0 && endTime.compareTo(new Date()) > 0) {
            return Result.fail("开始时间和结束时间均不能大于今天");
        }
        try {
            return bottleService.getUserListCountByTime(userId, startTime, endTime);
        } catch (Exception e) {
            log.info("查询失败", e);
            return Result.fail("查询失败");
        }
    }

    /**
     * 瓶子/问题的统计,可以管理员后台查看，用户前台查看总的问题
     * @param bottleCategory 瓶子的类别，0：作业求解瓶，1：知识问答瓶
     * @param bottleStatus   是否是优选瓶子：0：普通瓶子，1：优选瓶子
     * @param startTime      开始时间 不能大于当前时间
     * @param endTime        结束时间 不能大于当前时间
     * @param page           当前页
     * @param pageSize       页面尺寸
     * @return
     */
    @RequestMapping(value = "/listAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Result getListByConditon(@RequestParam(value = "bottleCategory", required = false) Byte bottleCategory,
                                    @RequestParam(value = "bottleStatus", required = false) Byte bottleStatus,
                                    @RequestParam(value = "startTime", required = false) Date startTime,
                                    @RequestParam(value = "endTime", required = false) Date endTime,
                                    @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                    @RequestParam(value = "pageSize", required = false, defaultValue = "15") Integer pageSize) {
        if ((startTime != null && startTime.compareTo(new Date()) > 0) || (endTime != null && (endTime.compareTo(new Date()) > 0))
                || (bottleCategory != null && (bottleCategory != Constant.BOTTLE_CATRGORY_SOLVE && bottleCategory != Constant.BOTTLE_CATRGORY_QUESTIOLN))
                || (bottleCategory != null && (bottleStatus != Constant.BOTTLE_COMMON && bottleStatus != Constant.BOTTLE_GOOD))) {
            return Result.fail("参数有误");
        }
        try{
            return bottleService.getListByConditon(bottleCategory, bottleStatus, startTime, endTime, page, pageSize);
        } catch (Exception e) {
            log.info("查询失败",e);
            return Result.fail("查询失败");
        }
    }

    /**
     * 用于管理员统计瓶子的分类及数量，形成统计图
     * @param startTime
     * @param endTime
     * @return
     */
    @RequestMapping(value = "/listAllCountByTime", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Result listAllCountByTime(@RequestParam(value = "startTime", required = false) Date startTime,
                                    @RequestParam(value = "endTime", required = false) Date endTime ) {
        if ((startTime != null && startTime.compareTo(new Date()) > 0) || (endTime != null && (endTime.compareTo(new Date()) > 0))){
            return Result.fail("参数有误");
        }
        try{
            return bottleService.listAllCountByTime(startTime, endTime);
        } catch (Exception e) {
            log.info("查询失败",e);
            return Result.fail("查询失败");
        }
    }

}
