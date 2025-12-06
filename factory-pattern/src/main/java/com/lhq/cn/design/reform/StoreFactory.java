package com.lhq.cn.design.reform;

import com.lhq.cn.design.reform.impl.CardCommodityService;
import com.lhq.cn.design.reform.impl.CouponCommodityService;
import com.lhq.cn.design.reform.impl.GoodsCommodityService;

public class StoreFactory {
    public ICommodity getCommodityService(Integer commodityType) {
        if (null == commodityType) return null;
        if (1 == commodityType) {
            return new CouponCommodityService();
        } else if (2 == commodityType) {
            return new GoodsCommodityService();
        }else if (3 == commodityType) {
            return new CardCommodityService();
        }
        throw new RuntimeException("不存在的奖品类型");
    }
}
