package com.lhq.cn.design.old.impl;


import com.lhq.cn.design.common.RedisUtils;
import com.lhq.cn.design.common.matter.EGM;
import com.lhq.cn.design.common.matter.IIR;
import com.lhq.cn.design.old.CacheService;

import java.util.concurrent.TimeUnit;

public class CacheServiceImpl implements CacheService {

    private RedisUtils redisUtils = new RedisUtils();
    private EGM egm = new EGM();
    private IIR iir = new IIR();

    public String get(String key, int redisType) {
        if (redisType == 1){
            return egm.gain(key);
        }else if (redisType == 2){
            return iir.get(key);
        }
        return redisUtils.get(key);
    }

    public void set(String key, String value, int redisType) {
        if (redisType == 1){
            egm.set(key, value);
        }else if (redisType == 2){
            iir.set(key, value);
        }
        redisUtils.set(key, value);
    }

    public void set(String key, String value, long timeout, TimeUnit timeUnit, int redisType) {
        if (redisType == 1){
            egm.setEx(key, value, timeout, timeUnit);
        }else if (redisType == 2){
            iir.setExpire(key, value, timeout, timeUnit);
        }
        redisUtils.set(key, value, timeout, timeUnit);
    }

    public void del(String key, int redisType) {
        if (redisType == 1){
            egm.delete(key);
        }else if (redisType == 2){
            iir.del(key);
        }
        redisUtils.del(key);
    }

}
