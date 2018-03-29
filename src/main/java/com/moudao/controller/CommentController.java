package com.moudao.controller;

import com.moudao.pojo.BComment;
import com.moudao.service.CommentService;
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
import sun.misc.Request;

import java.util.Date;
import java.util.List;

/**
 * author: MrWang
 * date: 2018/3/29 13:58
 */
@Controller
@RequestMapping("/comment")
public class CommentController {
    private static final Log log = LogFactory.getLog(CommentController.class);
    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Result createComment(@Validated(InsertValid.class) BComment comment, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            StringBuilder sb = new StringBuilder();
            final List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError objectError : allErrors) {
                sb.append(objectError.getDefaultMessage()).append(";    ");
            }
            return Result.fail(sb.toString(), "发表评论失败");
        }
        try{
            comment.setCreatedTime(new Date());
            comment.setUpdatedTime(new Date());
            return commentService.insert(comment);
        } catch (Exception e) {
            log.info("发表评论失败", e);
            return Result.fail("发表评论失败");
        }
    }

    /**
     * 根据瓶子的分页查询这个瓶子的相关的评论
     * @param commentStatus 优质瓶子(1)/一般瓶子(0)   不传的时候默认查所有的
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/getCommentListByBottleId/{bottleId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Result getCommentListByBottleId(@PathVariable(value = "bottleId", required = true) Integer bottleId,
                                           @RequestParam(value = "commentStatus", required = false) Byte commentStatus,
                                           @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                           @RequestParam(value = "pageSize",required = false, defaultValue = "15") Integer pageSize) {
        if(page <=0 || pageSize <=0 || (commentStatus != null && (commentStatus.byteValue() != 0 && commentStatus.byteValue() != 1))){
            log.info((commentStatus != null && (commentStatus.byteValue() != 0 && commentStatus.byteValue() != 1)));
            return Result.fail("参数错误");
        }
        try{
            return commentService.getCommentListByBottleId(bottleId,commentStatus,page,pageSize);
        } catch (Exception e) {
            log.info("查询失败", e);
            return Result.fail("查询失败");
        }
    }

    public static void main(String[] args) {
        Byte b = new Byte((byte)0);
        System.out.println(b == 0);
    }



}
