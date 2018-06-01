package com.moudao.controller;

import com.moudao.pojo.Bottle;
import com.moudao.pojo.Chance;
import com.moudao.service.BottleService;
import com.moudao.service.ChanceService;
import com.moudao.service.UserService;
import com.moudao.util.ChanceBean;
import com.moudao.util.Constant;
import com.moudao.util.Result;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 这个是扔/捞漂流瓶机会的controller
 * author: MrWang
 * date: 2018/3/28 13:00
 */
@Controller
@RequestMapping("/chance")
public class ChanceController {
    private static final Log log = LogFactory.getLog(ChanceController.class);

    @Autowired
    private ChanceService chanceService;
    @Autowired
    private BottleService bottleService;

    /**
     * 查询扔/捞瓶子的机会，顺便返回用户捞到的的瓶子列表个数
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Result getChance(@PathVariable(value = "userId", required = true) Integer userId) {
        try {
            Chance refloat = chanceService.getRefloatByUserId(userId);
            if (refloat == null) {
                refloat = newChance(userId, (byte) 0);
            }
            Chance throwC = chanceService.getThrowChanceByUserId(userId);
            if (throwC == null) {
                throwC = newChance(userId, (byte) 1);
            }
            List<Bottle> list = bottleService.selectRefloatList(userId);
            ChanceBean bean = new ChanceBean(refloat.getChanceNum(), throwC.getChanceNum(), list.size(), 0);
            return Result.success(bean);
        } catch (Exception e) {
            log.info("查询失败，请稍后重试！", e);
            return Result.fail("查询失败，请稍后重试！");
        }
    }

    private Chance newChance(Integer userId, byte flag) {
        return chanceService.createBottle(userId, flag);
    }


    /**
     * 用户获取自己的积分兑现机会
     * @param userId
     * @return
     */
    @RequestMapping(value = "getIntegral/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Result getIntegral(@PathVariable(value = "userId", required = true) Integer userId) {
        try {
            Integer num =  chanceService.getIntegral(userId);
            return Result.success(num);
        } catch (Exception e) {
            log.info("查询失败，请稍后重试！", e);
            return Result.fail("查询失败，请稍后重试！");
        }
    }

    /**
     * 用户使用自己的积分兑现机会
     * @param userId
     * @param integral
     * @param chanceCategory 要兑现的机会的类型 0：捞瓶子，1：扔瓶子
     * @return
     */
    @RequestMapping(value = "/{userId}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Result cashIntegral(@PathVariable(value = "userId", required = true) Integer userId,
                               @RequestParam(value = "integral",required = true) Integer integral,
                               @RequestParam(value = "chanceCategory",required = true) Byte chanceCategory) {
        Chance chance = null;
        if(integral.intValue() > 100 || integral.intValue() <= 0){
            return Result.fail("兑现积分不能大于100次，且不能小于0次");
        }
        try{
            if(Constant.CHANCE_CATEGORY_REFLOAT == chanceCategory.byteValue()){
                chance = chanceService.getRefloatByUserId(userId);
                chance = verifyExistChance(chance, userId, chanceCategory.byteValue());
            } else if (Constant.CHANCE_CATEGORY_THROW == chanceCategory.byteValue()) {
                chance = chanceService.getThrowChanceByUserId(userId);
                chance = verifyExistChance(chance, userId, chanceCategory.byteValue());
            } else {
                return Result.fail("未知的请求，要兑现的机会的类型只能是： 0：捞瓶子，1：扔瓶子");
            }
            int chanceNum = chance.getChanceNum() + integral.intValue();
            if(chanceNum > 100){
                return Result.fail("兑现积分失败，兑现后次数不能超过100次");
            }
            chance.setChanceNum(chanceNum);
            return chanceService.cashIntegral(userId,integral,chance);
        } catch (Exception e) {
            log.info("兑现积分失败", e);
            return Result.fail("兑现积分失败");
        }
    }

    private Chance verifyExistChance(Chance chance, Integer userId, byte flag) {
        if(chance == null){
            chance = chanceService.createBottle(userId, flag);
        }
        return chance;
    }

}
