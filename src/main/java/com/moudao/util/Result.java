package com.moudao.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据工具类
 * @param <T>
 */
public class Result<T> implements Serializable {

    private static final long serialVersionUID = -4569216979022946969L;
    private T data;//返回数据

    private boolean isSuccess = false;//成功标识

    private String resultMsg = "执行失败!";//结果信息

    public Result(){

    }

    public static <T> Result<T> fail(){
        return new Result<>();
    }

    public static <T> Result<T> fail(String msg){
        Result<T> result = fail();
        result.setResultMsg(msg);
        return result;
    }


    public static <T> Result<T> fail(String msg, T t){
        Result<T> result = fail();
        result.setResultMsg(msg);
        result.setData(t);
        return result;
    }

    public static <T> Result<T> fail(String msg, Throwable t){
        Result<T> result = fail();
        result.setResultMsg(msg + ": " + t);
        return result;
    }

    public static <T> Result<T> success(String msg){
        Result<T> result = success();
        result.setResultMsg(msg);
        return result;
    }

    public static <T> Result<T> success(){
        Result<T> result = new Result<>();
        result.setResultMsg("执行成功！");
        result.setIsSuccess(true);
        return result;
    }

    public static <T> Result<T> success(T t){
        Result<T> result = success();
        result.setData(t);
        return result;
    }
    public static <T> Result<T> success(T t, String msg){
        Result<T> result = success();
        result.setData(t);
        result.setResultMsg(msg);
        return result;
    }

    public static <T> Result<T> success(Result<T> result){
        if(result == null){
            return success();
        }
        result.setResultMsg("执行成功！");
        result.setIsSuccess(true);
        return result;
    }
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }


    /**
     * 添加返回数据
     * @param key key
     * @param value value
     * @return
     */
    public Result addData(String key, Object value) {
        Map<String,Object> map;
        if(this.data == null){
            map = new HashMap<>();
        }else if(this.data instanceof Map){
            map = (Map<String, Object>) this.data;
        }else {
            throw new RuntimeException("not support");
        }
        map.put(key,value);
        setData((T) map);
        return this;
    }

    /**
     * 删除数据
     * @param keys
     * @return
     */
    public Result removeData(String... keys) {
        if(this.data==null || !(this.data instanceof Map)){
            return this;
        }
        Map<String,Object> map = (Map<String, Object>) this.data;
        for (String key : keys) {
            map.remove(key);
        }
        return this;
    }

    /**
     * 清空返回数据
     * @return
     */
    public Result clearData() {
        this.data = null;
        return this;
    }


}
