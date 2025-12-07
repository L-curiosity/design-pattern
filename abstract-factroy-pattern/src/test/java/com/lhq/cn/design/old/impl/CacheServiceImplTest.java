package com.lhq.cn.design.old.impl;

import com.lhq.cn.design.old.CacheService;

class CacheServiceImplTest {
    public static void main(String[] args) {
        CacheService cacheService = new CacheServiceImpl();
        cacheService.set("1", "1", 1);
        System.out.println(cacheService.get("1", 1));

        cacheService.set("2", "2", 2);
        System.out.println(cacheService.get("2", 2));
    }
}