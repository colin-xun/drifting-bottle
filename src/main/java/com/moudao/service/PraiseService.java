package com.moudao.service;

import com.moudao.util.Result;

/**
 * author: MrWang
 * date: 2018/3/29 14:31
 */
public interface PraiseService {
    Result create(Integer targetId, Integer userId, Byte catetory);
}
