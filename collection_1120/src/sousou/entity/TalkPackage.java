package sousou.entity;

import sousou.common.Common;
import sousou.function.CallService;
import sousou.function.SendService;

/*
话唠套餐：
继承 套餐父类ServicePackage
实现2个接口：通话CallService  SendService
 */
public class TalkPackage extends ServicePackage implements CallService, SendService {
    private int talkTime;           //通话时长
    private int smsCount;           //短信个数

    //套餐数据初始化
    public TalkPackage() {
        this.talkTime = 500;
        this.smsCount = 30;
        this.price = 58;
    }

    public int getTalkTime() {
        return talkTime;
    }

    public void setTalkTime(int talkTime) {
        this.talkTime = talkTime;
    }

    public int getSmsCount() {
        return smsCount;
    }

    public void setSmsCount(int smsCount) {
        this.smsCount = smsCount;
    }

    //重写套餐父类中 showInfo输出的方法
    @Override
    public void showInfo() {
        System.out.println("话唠套餐：通话时长为："+this.talkTime+"分钟/月  短信条数为："+this.smsCount+"条/月 ," +
                "月租为："+price+"元/月" );

    }

    //通话时长 ---未实现此功能
    public int call(int minCount, MobileCard card) throws Exception {
        int temp = minCount;
        for (int i = 0; i < minCount; i++) {
           if (this.talkTime-card.getRealTalkTime()>=1){
               card.setRealTalkTime(card.getRealTalkTime()+1);
           }else if (card.getMoney()>0.2){
               card.setRealTalkTime(card.getRealTalkTime()+1);
               //card.setMoney(card.getMoney()-0.2);
               card.setConsumeAmount(Common.sub(card.getMoney(),0.2));
               card.setConsumeAmount(card.getConsumeAmount()+0.2);
           }else {
               temp = i;
               throw new Exception("您本次已通话 分钟。您的余额不足，请充值后再使用");
           }
        }

        return temp;
    }


    //发送短信数量---未实现此功能
    public int send(int count, MobileCard card) throws Exception {
        int temp = count;
        for (int i = 0; i < count; i++) {
            if (this.smsCount-card.getRealSMSCount()>=1){
                card.setRealSMSCount(card.getRealSMSCount()+1);
            }else if (card.getMoney()>=0.1){
                card.setRealSMSCount(card.getRealSMSCount()+1);
                card.setMoney(Common.sub(card.getMoney(),0.1));
                card.setConsumeAmount(card.getConsumeAmount()+0.1);
            }else {
                temp = i;
                throw new Exception("您当前已发送 条短信。您的余额不足，请充值后再使用。");
            }

        }
        return temp;
    }
}

