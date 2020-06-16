package sousou.function;

import sousou.entity.MobileCard;

/*
接口：发短信 发短信的条数：count
 */
public interface SendService {
    public int send(int count, MobileCard card) throws Exception;
}
