package com.moudao.util;

/**
 * author: MrWang
 * date: 2018/3/29 0:29
 */
public class ChanceBean {
    private int refloatNum;  //捞瓶子的数量
    private int throwNum;  //扔的数量
    private int refloatListNum; //用户的已经捞出的瓶子的数量
    private int throwListNum;   //用户的已经扔出的瓶子的数量

    public ChanceBean(int refloatNum, int throwNum, int refloatListNum, int throwListNum) {
        this.refloatNum = refloatNum;
        this.throwNum = throwNum;
        this.refloatListNum = refloatListNum;
        this.throwListNum = throwListNum;
    }

    public ChanceBean(int refloatNum, int throwNum) {
        this.refloatNum = refloatNum;
        this.throwNum = throwNum;
    }

    public ChanceBean(){}

    public int getRefloatNum() {
        return refloatNum;
    }

    public void setRefloatNum(int refloatNum) {
        this.refloatNum = refloatNum;
    }

    public int getThrowNum() {
        return throwNum;
    }

    public void setThrowNum(int throwNum) {
        this.throwNum = throwNum;
    }

    public int getRefloatListNum() {
        return refloatListNum;
    }

    public void setRefloatListNum(int refloatListNum) {
        this.refloatListNum = refloatListNum;
    }

    public int getThrowListNum() {
        return throwListNum;
    }

    public void setThrowListNum(int throwListNum) {
        this.throwListNum = throwListNum;
    }
}
