package sousou.entity;

import sousou.common.Common;
import sousou.function.NetService;

/*
网虫套餐：
继承 套餐父类。
实现上网 接口。
 */
public class NetPackage extends ServicePackage implements NetService {
    private int flow;       //上网流量


    public NetPackage(int flow) {
        super();
        this.flow = flow;
    }

    //套餐数据初始化
    public NetPackage() {
        this.flow =1024*3;
        this.price = 68.0;

    }

    public int getFlow() {
        return flow;
    }

    public void setFlow(int flow) {
        this.flow = flow;
    }

    @Override
    public void showInfo() {
        System.out.println("网虫套餐： 上网流量为："+this.flow/1024+"GB/月,月资费是："+this.price+"元/月");
    }


    //提供上网服务
    public int netPlay(int flow, MobileCard card){
        int temp = flow;
        for (int i = 0; i < flow; i++) {
            //第一种情况：套餐剩余流量可以支持使用1M流量。
            if (this.flow-card.getRealFlow()>=1){
                card.setRealFlow(card.getRealFlow()+1);
            }else if (card.getMoney()>= 0.1){
                card.setRealFlow(card.getRealFlow()+1);
                card.setMoney(Common.sub(card.getMoney(),0.1));
                card.setConsumeAmount(card.getConsumeAmount()+0.1);
            }else{
                temp = i;
                System.out.println("本次已使用流量 "+i+"MB，您的余额不足，请充值后再使用");
            }
        }

        return temp;
    }



}
