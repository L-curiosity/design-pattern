package com.lhq.cn.design.old;


import java.util.HashMap;

class PrizeControllerTest {
    public static void main(String[] args) {
        PrizeController prizeController = new PrizeController();
        AwardReq req = new AwardReq();
        req.setAwardNumber("number-00000001");
        //优惠券
        req.setAwardType(1);
        req.setBizId("bizId-00000001");
        req.setuId("uid-00000001");
        AwardRes awardRes = prizeController.grantPrize(req);
        System.out.println(awardRes.getCode() + ":" + awardRes.getInfo());

        //实物
        req.setAwardType(2);
        req.setBizId("bizId-00000002");
        req.setuId("uid-00000002");
        req.setAwardNumber("number-00000002");
        req.setExtMap(new HashMap<String, String>());
        req.getExtMap().put("userName", "Lhq");
        req.getExtMap().put("userPhone", "13800000002");
        req.getExtMap().put("consigneeUserName", "Lhq");
        req.getExtMap().put("consigneeUserPhone", "13800000002");
        req.getExtMap().put("consigneeUserAddress", "北京市朝阳区");
        awardRes = prizeController.grantPrize(req);
        System.out.println(awardRes.getCode() + ":" + awardRes.getInfo());

        //爱奇艺卡
        req.setAwardType(3);
        req.setBizId("bizId-00000003");
        req.setuId("uid-00000003");
        req.setAwardNumber("number-00000003");
        awardRes = prizeController.grantPrize(req);
        System.out.println(awardRes.getCode() + ":" + awardRes.getInfo());
    }
}