package com.lhq.cn.design.reform.factory;


import com.lhq.cn.design.common.CacheService;
import com.lhq.cn.design.reform.factory.impl.IIRCacheAdapter;

class JDKProxyTest {
    public static void main(String[] args) throws Exception {
        CacheService cache_IIR = JDKProxy.getProxy(CacheService.class, new IIRCacheAdapter());
        cache_IIR.set("user_name_01", "lhq");
        System.out.println(cache_IIR.get("user_name_01"));
    }

}