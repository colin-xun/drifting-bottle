package com.moudao.util;

/**
 * author: MrWang
 * date: 2018/3/28 20:45
 */
public interface Constant {
    int DEFAULT_PAGE = 1;
    int DEFAULT_PAGE_SIZE=15;
    int CHANCE_INIT_NUM = 6;
    byte COMMENT_GOOD = 1;
    byte COMMENT_COMMON = 0;

    byte CHANCE_CATEGORY_REFLOAT = 0;
    byte CHANCE_CATEGORY_THROW = 1;

    byte PRAISE_CATRGORY_BOTTLLE = 0;  //表示这个赞的类型是瓶子（0）/评论（1）
    byte PRAISE_CATRGORY_COMMENT = 1;  //表示这个赞的类型是瓶子（0）/评论（1）

    byte BOTTLE_CATRGORY_SOLVE = 0;
    byte BOTTLE_CATRGORY_QUESTIOLN = 1;
    byte BOTTLE_GOOD = 1;
    byte BOTTLE_COMMON = 0;


    int GOOD_THRESHOLD = 10;           //表示超过这个数的可以认定为优质
}
