package com.lhq.cn.design.reform.factory.impl;

import com.lhq.cn.design.common.matter.EGM;
import com.lhq.cn.design.reform.factory.ICacheAdapter;

import java.util.concurrent.TimeUnit;

public class EGMCacheAdapter implements ICacheAdapter {
    private EGM egm = new EGM();

    @Override
    public String get(String key) {
        return egm.gain(key);
    }

    @Override
    public void set(String key, String value) {
        egm.set(key, value);
    }

    @Override
    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        egm.setEx(key, value, timeout, timeUnit);
    }

    @Override
    public void del(String key) {
        egm.delete(key);
    }
}
