package sousou.entity;

import sousou.common.Common;
import sousou.function.CallService;
import sousou.function.NetService;
import sousou.function.SendService;

/*
超人套餐：
继承：套餐父类
实现接口：通话、上网、发短信
 */
public class SuperPackage extends ServicePackage implements CallService, NetService, SendService {
    private int talkTime;   //通话时长
    private int SMSCount;   //短信数量
    private int flow;       //上网流量


    public SuperPackage() {
        //套餐数据初始化
        this.talkTime = 200;
        this.SMSCount = 50;
        this.flow = 1*1024;
        this.price = 78;
    }

    public int getTalkTime() {
        return talkTime;
    }

    public void setTalkTime(int talkTime) {
        this.talkTime = talkTime;
    }

    public int getSMSCount() {
        return SMSCount;
    }

    public void setSMSCount(int SMSCount) {
        this.SMSCount = SMSCount;
    }

    public int getFlow() {
        return flow;
    }

    public void setFlow(int flow) {
        this.flow = flow;
    }


    @Override
    public void showInfo() {
        System.out.println("超人套餐：通话时长为："+this.talkTime+"分钟/月  短信条数为："+this.SMSCount+"条/月  " +
                " 上网流量为："+this.flow/1024+"GB/月");
    }


    //提供通话服务
    public int call(int minCount,MobileCard card) throws Exception {
        int temp = minCount;
        for (int i = 0; i <minCount ; i++) {
            if (this.talkTime-card.getRealTalkTime()>=1){
                card.setRealTalkTime(card.getRealTalkTime()+1);
            }else if (card.getMoney()>=0.2){
                card.setRealTalkTime(card.getRealTalkTime()+1);
                card.setMoney(Common.sub(card.getMoney(),0.2));
                card.setConsumeAmount(card.getConsumeAmount()+0.2);
            }else{
                temp = i;
                throw new Exception("本次已通话"+i+" 分钟，您的余额不足，请充值后再使用！");
            }
        }
        return temp;
    }
    //发送短信服务
    public int send(int count, MobileCard card) throws Exception {
        int temp = count;
        for (int i = 0; i < count; i++) {
            if (this.SMSCount-card.getRealSMSCount()>=1){
                card.setRealSMSCount(card.getRealSMSCount()+1);
            }else if (card.getMoney()>=0.1){
                card.setRealSMSCount(card.getRealSMSCount()+1);
                card.setMoney(Common.sub(card.getMoney(),0.1));
                card.setConsumeAmount(card.getConsumeAmount()+0.1);
            }else {
                temp = i;
                throw new Exception("本次已发送短信"+i+" 条，您的余额不足，请充值后再使用！");
            }

        }
        return temp;
    }
    //提供上网服务
    public int netPlay(int flow, MobileCard card) {
        int temp = flow;
        for (int i = 0; i <flow ; i++) {
            if (this.flow - card.getRealFlow()>=1){
                card.setRealFlow(card.getRealFlow()+1);
            }else if (card.getMoney()>0.1){
                card.setRealFlow(card.getRealFlow()+1);
                card.setMoney(Common.sub(card.getMoney(),0.1));
                card.setConsumeAmount(card.getConsumeAmount()+0.1);
            }else {
                temp =i;
                System.out.println("本次已使用流量"+i+"MB，您的余额不足，请充值后在使用！");
            }

        }
        return temp;
    }
}
