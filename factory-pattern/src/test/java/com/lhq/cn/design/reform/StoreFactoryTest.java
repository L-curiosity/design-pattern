package com.lhq.cn.design.reform;


import java.util.HashMap;

class StoreFactoryTest {

    public static void main(String[] args) throws Exception {
        StoreFactory storeFactory = new StoreFactory();
        // 1.优惠券
        ICommodity commodity = storeFactory.getCommodityService(1);
        commodity.sendCommodity("uid-001", "number-001", "bizId-001", null);
        // 2.实物商品
        commodity = storeFactory.getCommodityService(2);
        HashMap<String, String> extMap = new HashMap<String, String>();
        extMap.put("consigneeUserName", "张三");
        extMap.put("consigneeUserPhone", "153xxxx");
        extMap.put("consigneeUserAddress", "浙江省杭州市西湖区文三路 138 号东方通信大厦");
        commodity.sendCommodity("uid-002", "number-002", "bizId-002", extMap);
        // 3.爱奇艺兑换卡
        commodity = storeFactory.getCommodityService(3);
        commodity.sendCommodity("uid-003", "number-003", "bizId-003", null);
    }
}