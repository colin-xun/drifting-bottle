package com.moudao.util;

import com.moudao.pojo.BComment;
import com.moudao.pojo.Bottle;

import java.util.List;

/**
 * 封装瓶子的类，包括其评论
 * author: MrWang
 * date: 2018/3/29 1:26
 */
public class BottleResultBean<T,K> {
    private T bottle;
    private List<K> goodComments;
    private List<K> commonComments;

    public BottleResultBean(){}

    public BottleResultBean(T bottle, List<K> goodComments, List<K> commonComments) {
        this.bottle = bottle;
        this.goodComments = goodComments;
        this.commonComments = commonComments;
    }

    public T getBottle() {
        return bottle;
    }

    public void setBottle(T bottle) {
        this.bottle = bottle;
    }

    public List<K> getGoodComments() {
        return goodComments;
    }

    public void setGoodComments(List<K> goodComments) {
        this.goodComments = goodComments;
    }

    public List<K> getCommonComments() {
        return commonComments;
    }

    public void setCommonComments(List<K> commonComments) {
        this.commonComments = commonComments;
    }
}
