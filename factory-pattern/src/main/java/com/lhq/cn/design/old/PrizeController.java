package com.lhq.cn.design.old;

import com.lhq.cn.design.common.card.IQiYiCardService;
import com.lhq.cn.design.common.coupon.CouponResult;
import com.lhq.cn.design.common.coupon.CouponService;
import com.lhq.cn.design.common.goods.DeliverReq;
import com.lhq.cn.design.common.goods.GoodsService;

import java.util.Map;

public class PrizeController {
    public AwardRes grantPrize(AwardReq  req){
        //奖品类型
        Integer awardType = req.getAwardType();
        //奖品编号
        String awardNumber = req.getAwardNumber();
        //业务id
        String bizId = req.getBizId();
        //用户id
        String uid = req.getuId();
        //扩展信息
        Map<String, String> extMap = req.getExtMap();
        AwardRes awardRes = new AwardRes("0000", "发放成功");

        if (1 == awardType){
            //优惠券
            CouponService couponService = new CouponService();
            CouponResult couponResult = couponService.sendCoupon(uid, awardNumber, bizId);
            awardRes.setCode(couponResult.getCode());
            awardRes.setInfo(couponResult.getInfo());
        }else if (2 == awardType){
            //实物商品
            GoodsService goodsService = new GoodsService();
            DeliverReq deliverReq = new DeliverReq();
            deliverReq.setOrderId(bizId);
            deliverReq.setSku(awardNumber);
            deliverReq.setUserName(extMap.get("userName"));
            deliverReq.setUserPhone(extMap.get("userPhone"));
            deliverReq.setConsigneeUserName(extMap.get("consigneeUserName"));
            deliverReq.setConsigneeUserPhone(extMap.get("consigneeUserPhone"));
            Boolean b = goodsService.deliverGoods(deliverReq);
            if (!b){
                awardRes.setCode("0001");
                awardRes.setInfo("发放失败");
            }
        }else if (3 == awardType){
            //第三方兑换卡(爱奇艺)
            IQiYiCardService iQiYiCardService = new IQiYiCardService();
            iQiYiCardService.grantToken(awardNumber, bizId);
        }

        return awardRes;
    }
}
