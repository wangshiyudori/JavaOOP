package sousou.function;

import sousou.entity.MobileCard;

/*
接口：打电话  通话分钟数，手机卡
 */
public interface CallService {
    public abstract int call(int minCount, MobileCard card) throws Exception;

}
